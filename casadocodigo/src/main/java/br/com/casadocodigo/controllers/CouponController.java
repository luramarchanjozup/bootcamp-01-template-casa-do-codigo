package br.com.casadocodigo.controllers;

import br.com.casadocodigo.dtos.CouponDto;
import br.com.casadocodigo.forms.CouponForm;
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
    public ResponseEntity<CouponDto> createCoupon(@RequestBody @Valid CouponForm couponForm){

        Coupon coupon = couponForm.toEntity();

        if(coupon != null){
            couponRepository.save(coupon);
            return ResponseEntity.ok(new CouponDto(coupon));
        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{couponId}")
    public ResponseEntity<CouponDto> updateCoupon(@PathVariable @Valid Long couponId,
                                                  @RequestBody CouponForm couponForm){

        Coupon coupon = couponForm.toEntity();

        if(coupon != null){

            coupon.setId(couponId);
            couponRepository.save(coupon);
            return ResponseEntity.ok(new CouponDto(coupon));

        }

        return ResponseEntity.notFound().build();

    }
}
