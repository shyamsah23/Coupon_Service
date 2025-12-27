package com.Shyam.Coupon_Service.dto;

import java.util.List;

public class OrderSummaryDTO {

    private Long orderId;
    private Long totalAmount;
    private List<OrderItemDTO> items;

    public OrderSummaryDTO() {
    }

    public OrderSummaryDTO(Long orderId, Long totalAmount, List<OrderItemDTO> items) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.items = items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
