package com.casadocodigo.casaDoCodigo.controllers;

import javax.validation.Valid;

import com.casadocodigo.casaDoCodigo.controllers.form.CouponForm;
import com.casadocodigo.casaDoCodigo.model.Coupon;
import com.casadocodigo.casaDoCodigo.services.CouponServices;

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
    private CouponServices couponServices;
    
    @PostMapping
    public ResponseEntity<Coupon> createCoupon(@RequestBody @Valid CouponForm form) {
        return ResponseEntity.ok().body(couponServices.createCoupon(form));
    }

    @PutMapping
    public ResponseEntity<Coupon> editCoupon(@RequestBody @Valid CouponForm form) {
        return ResponseEntity.ok().body(couponServices.editCoupon(form));
    }
}
