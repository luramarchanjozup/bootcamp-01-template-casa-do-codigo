package com.apicasadocodigo.casadocodigo.controller;

import com.apicasadocodigo.casadocodigo.model.Coupon;
import com.apicasadocodigo.casadocodigo.request.CouponRequest;
import com.apicasadocodigo.casadocodigo.response.CouponResponse;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import com.apicasadocodigo.casadocodigo.validator.UniqueCouponCodValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping("/coupons")
@RestController
public class CouponController {

    @Autowired
    private GenericDAO genericDAO;

    @Autowired
    private UniqueCouponCodValidator uniqueCouponCodValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(uniqueCouponCodValidator);
    }

    @PostMapping
    public ResponseEntity<?> saveCoupon(@RequestBody @Valid CouponRequest request, UriComponentsBuilder builder){
        Long idAddress = genericDAO.saveEntity(request.toModel()).getId();
        URI uri =  builder.path("/authors/{id}").build(idAddress);
        return ResponseEntity.ok(uri);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchase(@PathVariable Long id){

        CouponResponse response = new CouponResponse(genericDAO.findEntityDyId(Coupon.class, id));
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCoupon(@PathVariable Long id, @RequestBody CouponRequest request){

        Coupon coupon = genericDAO.findEntityDyId(Coupon.class, id);
        coupon.setProperties(request.getCod(), request.getPercentValue(), request.getValidateDate());
        genericDAO.saveEntity(coupon);

        return ResponseEntity.ok().build();
    }

}
