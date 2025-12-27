package com.Shyam.Coupon_Service.entity;

import com.Shyam.Coupon_Service.enums.DiscountType;
import com.Shyam.Coupon_Service.enums.PaymentType;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private double discountValue;
    private Double maxDiscount;
    private boolean stackable;

    @ElementCollection
    private List<String> allowedCategory;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<PaymentType> allowedPaymentMethods;

    public Coupon() {
    }

    public Coupon(Long id, DiscountType discountType, double discountValue, Double maxDiscount, boolean stackable, List<String> allowedCategory, Set<PaymentType> allowedPaymentMethods) {
        this.id = id;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.maxDiscount = maxDiscount;
        this.stackable = stackable;
        this.allowedCategory = allowedCategory;
        this.allowedPaymentMethods = allowedPaymentMethods;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    public Double getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(Double maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public boolean isStackable() {
        return stackable;
    }

    public void setStackable(boolean stackable) {
        this.stackable = stackable;
    }

    public List<String> getAllowedCategory() {
        return allowedCategory;
    }

    public void setAllowedCategory(List<String> allowedCategory) {
        this.allowedCategory = allowedCategory;
    }

    public Set<PaymentType> getAllowedPaymentMethods() {
        return allowedPaymentMethods;
    }

    public void setAllowedPaymentMethods(Set<PaymentType> allowedPaymentMethods) {
        this.allowedPaymentMethods = allowedPaymentMethods;
    }
}
