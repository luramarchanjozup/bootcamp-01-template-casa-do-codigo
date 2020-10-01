package com.casadocodigo.casaDoCodigo.services;

import javax.transaction.Transactional;

import com.casadocodigo.casaDoCodigo.controllers.form.CouponForm;
import com.casadocodigo.casaDoCodigo.model.Coupon;
import com.casadocodigo.casaDoCodigo.repositories.CouponRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServices {
    
    @Autowired
    private CouponRepository couponRepository;

    @Transactional
    public Coupon createCoupon(CouponForm form) {
        float percentage = (float)form.getPercentage() / 100;
        Coupon coupon = new Coupon(form.getCode(), percentage, form.getExpirationDate());
        couponRepository.save(coupon);

        return coupon;
    }
}
