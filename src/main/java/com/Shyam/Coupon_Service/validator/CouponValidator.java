package com.Shyam.Coupon_Service.validator;

import com.Shyam.Coupon_Service.entity.Coupon;
import com.Shyam.Coupon_Service.entity.CouponContext;
import com.Shyam.Coupon_Service.exception.InvalidCouponException;
import com.Shyam.Coupon_Service.rule.CouponRule;

import java.util.List;

public class CouponValidator {

    public void validateCoupon(List<CouponRule> rules, CouponContext context, Coupon coupon) {

        for (CouponRule rule : rules) {
            if (!rule.isSatisfied(context, coupon)) {
                throw new InvalidCouponException("Rules Not Satisified");
            }
        }
    }
}
