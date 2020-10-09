package com.casadocodigo.repository;

import com.casadocodigo.entity.Coupon;
import org.springframework.data.repository.Repository;

public interface CouponRepository extends Repository<Coupon, Long> {

    Coupon getByCode(String code);
}
