package com.apicasadocodigo.casadocodigo.validator;

import com.apicasadocodigo.casadocodigo.model.Coupon;
import com.apicasadocodigo.casadocodigo.request.CouponRequest;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UniqueCouponCodValidator implements Validator {

    @Autowired
    private GenericDAO genericDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return CouponRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CouponRequest couponRequest = (CouponRequest) object;

        boolean exists = genericDAO
                        .findEntityByAtribute(Coupon.class, "cod", couponRequest.getCod());

        if(!exists){
            errors.reject("cupom", null, "Já existe um(a) outro(a) cupom com o código "
            + couponRequest.getCod());
        }
    }
}