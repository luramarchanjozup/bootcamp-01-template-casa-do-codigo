package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.domain.Coupon;
import br.com.zup.casadocodigo.dto.CouponDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

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

    @PutMapping("/{id}")
    @Transactional

    public ResponseEntity<?> updateCoupon(@PathVariable("id") Long id, @RequestBody @Valid CouponDTO couponDTO){
        Coupon oneCupon = entityManager.find(Coupon.class, id);

        if(oneCupon == null) {
            return ResponseEntity.notFound().build();
        }

        List<Coupon> codeCouponList = couponDTO.ValidatesDuplicity(id, entityManager);

        if(codeCouponList.size() > 0) {
            return ResponseEntity.notFound().build();
        }

        oneCupon = couponDTO.toModelSet(oneCupon);
        entityManager.merge(oneCupon);
        return ResponseEntity.ok().body(couponDTO);

    }
}
