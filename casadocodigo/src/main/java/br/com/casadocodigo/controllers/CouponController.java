package br.com.casadocodigo.controllers;

import br.com.casadocodigo.models.Coupon;
import br.com.casadocodigo.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    private CouponRepository couponRepository;

    @PostMapping
    public ResponseEntity<Coupon> createCoupon(@RequestBody @Valid Coupon coupon){
        if(coupon != null){

            couponRepository.save(coupon);
            return ResponseEntity.ok(coupon);

        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{couponId}")
    public ResponseEntity<Coupon> updateCoupon(@PathVariable @Valid Long couponId,
                                               @RequestBody Coupon coupon){
        if(coupon != null){
            coupon.setId(couponId);
            couponRepository.save(coupon);
            return ResponseEntity.ok(coupon);
        }

        return ResponseEntity.notFound().build();

    }

}
