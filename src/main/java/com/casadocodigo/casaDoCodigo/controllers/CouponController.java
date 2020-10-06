package com.casadocodigo.casaDoCodigo.controllers;

import javax.validation.Valid;
import javax.validation.ValidationException;

import com.casadocodigo.casaDoCodigo.controllers.form.CouponForm;
import com.casadocodigo.casaDoCodigo.model.Coupon;
import com.casadocodigo.casaDoCodigo.repositories.CouponRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    
    @Autowired
    private CouponRepository couponRepository;
    
    @PostMapping
    public ResponseEntity<Coupon> createCoupon(@RequestBody @Valid CouponForm form) {
        if(couponRepository.findByCode(form.getCode()).isPresent()) {
            throw new ValidationException("Coupon of code " + form.getCode() + " already exists.\n"
                                        + "Try using the PUT method to edit a existing discount coupon.");
        }

        float percentage = (float)form.getPercentage() / 100;
        Coupon coupon = new Coupon(form.getCode(), percentage, form.getExpirationDate());
        couponRepository.save(coupon);

        return ResponseEntity.ok().body(coupon);
    }

    @PutMapping
    public ResponseEntity<Coupon> editCoupon(@RequestBody @Valid CouponForm form) {
        Coupon updatedCoupon = new Coupon(couponRepository.findByCode(form.getCode())
                                .orElseThrow(() -> new IllegalStateException("Coupon of code '" + form.getCode() + "' not found")), 
                                form.getCode(), ((float)form.getPercentage() / 100), form.getExpirationDate());
        couponRepository.save(updatedCoupon);

        return ResponseEntity.ok().body(updatedCoupon);
    }
}
