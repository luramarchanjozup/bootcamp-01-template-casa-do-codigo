package br.com.zup.bootcamp.controller;

import br.com.zup.bootcamp.controller.model.CouponRequest;
import br.com.zup.bootcamp.controller.model.GenericResponse;
import br.com.zup.bootcamp.domain.model.Coupon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<GenericResponse> register(@Validated @RequestBody CouponRequest request){
        Coupon coupon = request.convert();
        manager.persist(coupon);
        GenericResponse response = new GenericResponse("Coupon was registered");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
