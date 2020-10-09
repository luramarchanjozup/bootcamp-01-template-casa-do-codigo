package com.casadocodigo.validators;

import com.casadocodigo.entity.Coupon;
import com.casadocodigo.repository.CouponRepository;
import com.casadocodigo.requests.CouponRequest;
import com.casadocodigo.requests.PurchaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CouponValidator implements Validator {

	@Autowired
	private CouponRepository couponRepository;


	@Override
	public boolean supports(Class<?> clazz) {
		return PurchaseRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return ;
		}

		PurchaseRequest request = (PurchaseRequest) target;
		Optional<String> codeToValidate = request.getCoupon();
		if(codeToValidate.isPresent()) {
			Coupon coupon = couponRepository.getByCode(codeToValidate.get());
			if(!coupon.valid()) {
				errors.rejectValue("codigoCupom", null, "Este cupom não é mais válido");
			}
		}
	}


}
