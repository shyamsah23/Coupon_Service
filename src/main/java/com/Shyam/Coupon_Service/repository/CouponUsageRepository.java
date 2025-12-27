package com.Shyam.Coupon_Service.repository;

import com.Shyam.Coupon_Service.entity.CouponUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponUsageRepository extends JpaRepository<CouponUsage,Long> {

    boolean existsByUserIdAndCouponCode (Long userId,String couponCode);
}
