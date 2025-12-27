package com.Shyam.Coupon_Service.service;

import com.Shyam.Coupon_Service.dto.ApplyCouponRequestDTO;

public interface CouponService {
    double applyCoupon(ApplyCouponRequestDTO requestDTO);
}
