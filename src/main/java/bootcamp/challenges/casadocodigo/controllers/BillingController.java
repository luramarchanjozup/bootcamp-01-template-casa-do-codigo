package bootcamp.challenges.casadocodigo.controllers;

import bootcamp.challenges.casadocodigo.dtos.BillingDto;
import bootcamp.challenges.casadocodigo.dtos.CouponDto;
import bootcamp.challenges.casadocodigo.entities.Billing;
import bootcamp.challenges.casadocodigo.entities.Coupon;
import com.sun.istack.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

// Total Intrinsic Load Points: 4
@RestController
@Validated
public class BillingController {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @PostMapping("/billing")
    public ResponseEntity<Void> billingRegister( // 1 - BillingDto
                                                 @RequestBody @Valid BillingDto billingDto){
        @NotNull Billing billing = billingDto.toModel(entityManager); // 1 - Billing
        entityManager.persist(billing);
        return  ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(billing.getId())
                .toUri()).build();
    }
    @Transactional
    @PostMapping("/coupons")
    public ResponseEntity<Void> couponRegister( // 1 - CouponDto
            @RequestBody @Valid CouponDto couponDto){
        Coupon coupon = couponDto.toModel(); // 1 - Coupon
        entityManager.persist(coupon);
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(coupon.getId())
                .toUri()).build();
    }
    @GetMapping("/billing/{id}")
    public ResponseEntity<Billing> billingDetail(@PathVariable("id") Long id){
        Billing billing = entityManager.find(Billing.class, id);
        if(billing != null) return ResponseEntity.ok(billing);
        return ResponseEntity.notFound().build();
    }
}
