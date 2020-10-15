package com.guiferrini.CasaCodigo.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EstadoPaisValidador implements Validator {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean supports(Class<?> clazz) {
		return FluxoPagtoDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
		
		FluxoPagtoDTO fluxoPagtoDTO = (FluxoPagtoDTO) target;
		
		Pais pais = entityManager.find(Pais.class, fluxoPagtoDTO.getPais());
		Estado estado = entityManager.find(Estado.class, fluxoPagtoDTO.getEstado());
		
		if(!estado.validandoSePretencePais(pais)) {
			errors.rejectValue("Estado",null,"este Estado não é o do País selecionado");
			//errors.reject(errorCode, errorArgs, defaultMessage);
		}
		
	}
	
	
	
}
