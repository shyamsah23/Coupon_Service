package com.Shyam.Coupon_Service.strategy;

public class PercentageDiscountStrategy implements DiscountStrategy {

    private final double percent;
    private final double maxDiscount;

    public PercentageDiscountStrategy(double percent, double maxDiscount) {
        this.percent = percent;
        this.maxDiscount = maxDiscount;
    }


    public double calculateDiscountAmount(double amount) {
        return Math.max(amount * percent / 100, maxDiscount);
    }
}
