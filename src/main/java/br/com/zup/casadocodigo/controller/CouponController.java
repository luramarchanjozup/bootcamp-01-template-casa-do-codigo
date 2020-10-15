package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.domain.Coupon;
import br.com.zup.casadocodigo.dto.CouponDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "coupons")
public class CouponController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> createCoupon (@RequestBody @Valid CouponDTO couponDTO) {
        Coupon coupon = couponDTO.toModel(entityManager);
        entityManager.persist(coupon);
        return ResponseEntity.status(HttpStatus.CREATED).body(coupon);
    }
}
