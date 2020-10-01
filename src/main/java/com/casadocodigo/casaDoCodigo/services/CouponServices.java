package com.casadocodigo.casaDoCodigo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.casadocodigo.casaDoCodigo.controllers.form.CouponForm;
import com.casadocodigo.casaDoCodigo.model.Coupon;
import com.casadocodigo.casaDoCodigo.repositories.CouponRepository;
import com.casadocodigo.casaDoCodigo.services.exceptions.ObjectNotFoundException;

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

    @Transactional 
    public Coupon editCoupon(CouponForm form) {
        Optional<Coupon> couponObj = couponRepository.findByCode(form.getCode());
        Coupon coupon = couponObj.orElseThrow(() -> new ObjectNotFoundException(exceptionMsg(form.getCode())));

        Coupon updatedCoupon = new Coupon(coupon, form.getCode(), ((float)form.getPercentage() / 100), form.getExpirationDate());
        couponRepository.save(updatedCoupon);

        return updatedCoupon;
    }
    
    private String exceptionMsg(String code) {
        return "Coupon of code '" + code + "' not found";
    }
}
