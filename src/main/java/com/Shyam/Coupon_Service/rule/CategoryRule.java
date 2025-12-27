package com.Shyam.Coupon_Service.rule;

import com.Shyam.Coupon_Service.entity.Coupon;
import com.Shyam.Coupon_Service.entity.CouponContext;

public class CategoryRule implements CouponRule {
    public boolean isSatisfied(CouponContext context, Coupon coupon) {
        return context.getOrder().getItems().stream()
                .anyMatch(item -> coupon.getAllowedCategory().contains(item.getCategory()));
    }
}
