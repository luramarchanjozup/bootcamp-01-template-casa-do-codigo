package com.casadocodigo.casaDoCodigo.repositories;

import java.util.Optional;

import com.casadocodigo.casaDoCodigo.model.Coupon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Optional<Coupon> findByCode(String code);
}
