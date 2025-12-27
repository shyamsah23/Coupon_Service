package com.Shyam.Coupon_Service.rule;

import com.Shyam.Coupon_Service.entity.Coupon;
import com.Shyam.Coupon_Service.entity.CouponContext;

public interface CouponRule {
    boolean isSatisfied(CouponContext context, Coupon coupon);
}
