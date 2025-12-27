package com.Shyam.Coupon_Service.factory;

import com.Shyam.Coupon_Service.entity.Coupon;
import com.Shyam.Coupon_Service.entity.CouponContext;
import com.Shyam.Coupon_Service.repository.CouponUsageRepository;
import com.Shyam.Coupon_Service.rule.CategoryRule;
import com.Shyam.Coupon_Service.rule.CouponRule;
import com.Shyam.Coupon_Service.rule.FirstOrderRule;
import com.Shyam.Coupon_Service.rule.PaymentRule;

import java.util.Arrays;
import java.util.List;

public class RuleFactory {

    private final CouponUsageRepository couponUsageRepository;

    public RuleFactory(CouponUsageRepository couponUsageRepository) {
        this.couponUsageRepository = couponUsageRepository;
    }

    public List<CouponRule> generateRule() {
        return Arrays.asList(new CategoryRule(), new FirstOrderRule(couponUsageRepository), new PaymentRule());
    }
}
