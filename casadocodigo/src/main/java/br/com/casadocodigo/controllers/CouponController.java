package br.com.casadocodigo.controllers;

import br.com.casadocodigo.dtos.CouponDto;
import br.com.casadocodigo.forms.CouponForm;
import br.com.casadocodigo.models.Country;
import br.com.casadocodigo.models.Coupon;
import br.com.casadocodigo.repositories.CouponRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {


    private final CouponRepository couponRepository;

    private final EntityManager entityManager;

    private final Logger logger = LoggerFactory.getLogger(Coupon.class);



    public CouponController(CouponRepository couponRepository, EntityManager entityManager) {
        this.couponRepository = couponRepository;
        this.entityManager = entityManager;
    }


    @PostMapping
    public ResponseEntity<CouponDto> createCoupon(@RequestBody @Valid CouponForm couponForm,
                                                  UriComponentsBuilder uriComponentsBuilder){

        var coupon = couponForm.toEntity();
        couponRepository.save(coupon);


        return ResponseEntity
                .created(uriComponentsBuilder.path("/api/coupons").buildAndExpand().toUri())
                .body(new CouponDto(coupon));

    }


    @PutMapping("/{couponId}")
    public ResponseEntity<CouponDto> updateCoupon(@PathVariable @Valid Long couponId,
                                                  @RequestBody CouponForm couponForm){

        var coupon = couponForm.toEntity();
        entityManager.merge(coupon);

        return ResponseEntity.ok(new CouponDto(coupon));

    }
}
