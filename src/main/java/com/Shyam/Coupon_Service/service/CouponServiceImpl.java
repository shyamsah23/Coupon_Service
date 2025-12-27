package com.Shyam.Coupon_Service.service;

import com.Shyam.Coupon_Service.client.OrderServiceFeignClient;
import com.Shyam.Coupon_Service.dto.ApplyCouponRequestDTO;
import com.Shyam.Coupon_Service.dto.OrderSummaryDTO;
import com.Shyam.Coupon_Service.entity.Coupon;
import com.Shyam.Coupon_Service.entity.CouponContext;
import com.Shyam.Coupon_Service.entity.CouponUsage;
import com.Shyam.Coupon_Service.exception.InvalidCouponException;
import com.Shyam.Coupon_Service.factory.DiscountStrategyFactory;
import com.Shyam.Coupon_Service.factory.RuleFactory;
import com.Shyam.Coupon_Service.repository.CouponRepository;
import com.Shyam.Coupon_Service.repository.CouponUsageRepository;
import com.Shyam.Coupon_Service.strategy.DiscountStrategy;
import com.Shyam.Coupon_Service.validator.CouponValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CouponServiceImpl implements CouponService {

    private final OrderServiceFeignClient orderServiceFeignClient;
    private final CouponRepository couponRepository;
    private final CouponUsageRepository couponUsageRepository;
    private final RuleFactory ruleFactory;
    private final CouponValidator couponValidator;
    private final DiscountStrategyFactory discountStrategyFactory;


    public CouponServiceImpl(OrderServiceFeignClient orderServiceFeignClient, CouponRepository couponRepository, CouponUsageRepository couponUsageRepository, RuleFactory ruleFactory, CouponValidator couponValidator, DiscountStrategy strategy, DiscountStrategyFactory discountStrategyFactory) {
        this.orderServiceFeignClient = orderServiceFeignClient;
        this.couponRepository = couponRepository;
        this.couponUsageRepository = couponUsageRepository;
        this.ruleFactory = new RuleFactory(couponUsageRepository);
        this.discountStrategyFactory = new DiscountStrategyFactory();
        this.couponValidator = new CouponValidator();
    }


    public double applyCoupon(ApplyCouponRequestDTO requestDTO) {

        OrderSummaryDTO orderDetails = orderServiceFeignClient.getOrderDetails(requestDTO.getOrderId());

        Coupon coupon = couponRepository.findByCode(requestDTO.getCouponCode())
                .orElseThrow(() -> new InvalidCouponException("No Coupon Found"));

        CouponContext context = new CouponContext();
        context.setUserId(requestDTO.getUserId());
        context.setPaymentType(requestDTO.getPaymentType());
        context.setOrder(orderDetails);

        // Validations ( Chain Of Responsibility )
        couponValidator.validateCoupon(ruleFactory.generateRule(),context,coupon);

        DiscountStrategy strategy = discountStrategyFactory.getStrategy(coupon);
        double discountValue = strategy.calculateDiscountAmount(orderDetails.getTotalAmount());

        CouponUsage usage = new CouponUsage();
        usage.setCouponCode(coupon.getCode());
        usage.setUserId(requestDTO.getUserId());
        usage.setAppliedAt(LocalDateTime.now());
        usage.setOrderId(orderDetails.getOrderId());
        usage.setDiscountValue(discountValue);
        couponUsageRepository.save(usage);

        return discountValue;
    }
}
