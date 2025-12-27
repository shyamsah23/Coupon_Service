package com.Shyam.Coupon_Service.rule;

import com.Shyam.Coupon_Service.entity.Coupon;
import com.Shyam.Coupon_Service.entity.CouponContext;

public class PaymentRule implements CouponRule{
    public boolean isSatisfied(CouponContext context, Coupon coupon) {
        return coupon.getAllowedPaymentMethods().contains(context.getPaymentType());
    }
}
