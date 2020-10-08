package br.com.zup.bootcamp.controller;

import br.com.zup.bootcamp.controller.model.CouponRequest;
import br.com.zup.bootcamp.controller.model.CouponUpdateRequest;
import br.com.zup.bootcamp.controller.model.GenericResponse;
import br.com.zup.bootcamp.domain.model.Coupon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

// Intrinsic charge = 6
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

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<GenericResponse> update(
            @PathVariable String id, @Validated @RequestBody CouponUpdateRequest request
    ){
        GenericResponse response;
        Optional<Coupon> couponOPT = Optional.ofNullable(manager.find(Coupon.class, id));

        if(couponOPT.isEmpty()){
            response = new GenericResponse("Coupon not exist");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Coupon coupon = couponOPT.get();

        if(coupon.codeExist(manager, request.getCode())){
            response = new GenericResponse("Coupon code already exist");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        request.convert(coupon);
        manager.merge(coupon);

        response = new GenericResponse("Coupon was updated");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
