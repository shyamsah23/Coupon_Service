package com.Shyam.Coupon_Service.rule;

import com.Shyam.Coupon_Service.entity.Coupon;
import com.Shyam.Coupon_Service.entity.CouponContext;
import com.Shyam.Coupon_Service.repository.CouponUsageRepository;

public class FirstOrderRule implements CouponRule {

    private final CouponUsageRepository repository;

    public FirstOrderRule(CouponUsageRepository repository) {
        this.repository = repository;
    }

    public boolean isSatisfied(CouponContext context, Coupon coupon) {
        return !repository.existsByUserIdAndCouponCode(context.getUserId(), coupon.getCode());
    }
}
