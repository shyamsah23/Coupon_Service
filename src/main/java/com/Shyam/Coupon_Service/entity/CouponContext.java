package com.Shyam.Coupon_Service.entity;

import com.Shyam.Coupon_Service.dto.OrderSummaryDTO;
import com.Shyam.Coupon_Service.enums.PaymentType;

public class CouponContext {

    private Long userId;
    private OrderSummaryDTO order;
    private PaymentType paymentType;

    public CouponContext() {
    }

    public CouponContext(Long userId, OrderSummaryDTO order, PaymentType paymentType) {
        this.userId = userId;
        this.order = order;
        this.paymentType = paymentType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public OrderSummaryDTO getOrder() {
        return order;
    }

    public void setOrder(OrderSummaryDTO order) {
        this.order = order;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
