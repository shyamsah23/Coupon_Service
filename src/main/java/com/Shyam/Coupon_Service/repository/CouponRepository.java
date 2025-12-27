package com.Shyam.Coupon_Service.repository;

import com.Shyam.Coupon_Service.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    Optional<Coupon> findByCode(String code);
}
