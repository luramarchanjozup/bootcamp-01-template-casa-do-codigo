package com.casadocodigo.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.casadocodigo.requests.PurchaseRequest;

public class CpfOrCnpjValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PurchaseRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		PurchaseRequest purchaseRequest = (PurchaseRequest) target;

		if (!purchaseRequest.documentIsValid()) {
			errors.rejectValue("document", "O documento informado não é válido");
		}

	}

}
