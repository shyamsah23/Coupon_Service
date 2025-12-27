package com.Shyam.Coupon_Service.client;

import com.Shyam.Coupon_Service.dto.OrderSummaryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Order_service")
public interface OrderServiceFeignClient {

    @GetMapping("/order/details/{orderId}")
    public OrderSummaryDTO getOrderDetails(@PathVariable Long orderId);
}
