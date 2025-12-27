package com.Shyam.Coupon_Service.dto;

public class OrderItemDTO {
    private String category;
    private double price;

    public OrderItemDTO() {
    }

    public OrderItemDTO(String category, double price) {
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
