package com.casadocodigo.validators;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.casadocodigo.entity.Country;
import com.casadocodigo.entity.State;
import com.casadocodigo.requests.PurchaseRequest;

public class StateBelongToCountryValidator implements Validator {
	
	@PersistenceContext
	private EntityManager manager;

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

		if (!purchaseRequest.hasState()) {
			Country country = manager.find(Country.class, purchaseRequest.getIdCountry());
			State state = manager.find(State.class, purchaseRequest.getIdState());
			if(!state.belongToCountry(country)) {
				errors.rejectValue("idState",null,"O Estado não pertence ao País informado");	
			}
			
		}

	}

}
