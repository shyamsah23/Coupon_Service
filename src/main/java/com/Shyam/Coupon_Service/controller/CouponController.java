package com.Shyam.Coupon_Service.controller;

import com.Shyam.Coupon_Service.dto.ApplyCouponRequestDTO;
import com.Shyam.Coupon_Service.service.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    Logger log = LoggerFactory.getLogger(CouponController.class);
    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    public ResponseEntity<Double> applyCoupon(@RequestBody ApplyCouponRequestDTO requestDTO) {
        log.info("Started Applying Coupon");
        Double finalDiscount = couponService.applyCoupon(requestDTO);
        log.info("Successfully Applied Coupon");
        return new ResponseEntity<>(finalDiscount, HttpStatus.OK);
    }
}
