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

    //+1
    @Autowired
    private CouponRepository couponRepository;

    @PostMapping                                                        //+1
    public ResponseEntity<CouponDto> createCoupon(@RequestBody @Valid CouponForm couponForm){

        //+1
        Coupon coupon = couponForm.toEntity();


        couponRepository.save(coupon);

                                            //+1
        return ResponseEntity.ok(new CouponDto(coupon));

    }

    @PutMapping("/{couponId}")
    public ResponseEntity<CouponDto> updateCoupon(@PathVariable @Valid Long couponId,
                                                  @RequestBody CouponForm couponForm){
        //+1                                                      //+1
        Coupon coupon = couponForm.toEntity();

        coupon.setId(couponId);

        couponRepository.save(coupon);

                                        //+1
        return ResponseEntity.ok(new CouponDto(coupon));

    }
}
