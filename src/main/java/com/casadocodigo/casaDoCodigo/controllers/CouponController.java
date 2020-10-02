package com.casadocodigo.casaDoCodigo.controllers;

import java.net.URI;

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
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    
    @Autowired
    private CouponServices couponServices;
    
    @PostMapping
    public ResponseEntity<Coupon> createCoupon(@RequestBody @Valid CouponForm form, UriComponentsBuilder uriBuilder) {
        Coupon coupon = couponServices.createCoupon(form);
        URI uri = uriBuilder.path("coupon/{id}").buildAndExpand(coupon.getId()).toUri();
        return ResponseEntity.created(uri).body(coupon);
    }

    @PutMapping
    public ResponseEntity<Coupon> editCoupon(@RequestBody @Valid CouponForm form) {

        Coupon coupon = couponServices.editCoupon(form);
        return ResponseEntity.ok().body(coupon);
    }
}
