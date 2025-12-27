package com.Shyam.Coupon_Service.strategy;

public class FlatDiscount implements DiscountStrategy{

    private final double discount;

    public FlatDiscount(double discount) {
        this.discount = discount;
    }

    public double calculateDiscountAmount(double amount) {
        return discount;
    }
}
