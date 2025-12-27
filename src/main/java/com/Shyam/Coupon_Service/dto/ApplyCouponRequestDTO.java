package com.Shyam.Coupon_Service.dto;

import com.Shyam.Coupon_Service.enums.PaymentType;

public class ApplyCouponRequestDTO {
    private Long userId;
    private Long orderId;
    private String couponCode;
    private PaymentType paymentType;

    public ApplyCouponRequestDTO() {
    }

    public ApplyCouponRequestDTO(Long userId, Long orderId, String couponCode, PaymentType paymentType) {
        this.userId = userId;
        this.orderId = orderId;
        this.couponCode = couponCode;
        this.paymentType = paymentType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
