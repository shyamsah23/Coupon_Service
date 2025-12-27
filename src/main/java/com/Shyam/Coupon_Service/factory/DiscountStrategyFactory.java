package com.Shyam.Coupon_Service.factory;

import com.Shyam.Coupon_Service.entity.Coupon;
import com.Shyam.Coupon_Service.strategy.DiscountStrategy;
import com.Shyam.Coupon_Service.strategy.FlatDiscount;
import com.Shyam.Coupon_Service.strategy.PercentageDiscountStrategy;

public class DiscountStrategyFactory {

    public DiscountStrategy getStrategy(Coupon coupon) {
        return switch (coupon.getDiscountType()) {
            case FLAT -> new PercentageDiscountStrategy(coupon.getDiscountValue(), coupon.getMaxDiscount());
            case PERCENT -> new FlatDiscount(coupon.getDiscountValue());
        };
    }
}
