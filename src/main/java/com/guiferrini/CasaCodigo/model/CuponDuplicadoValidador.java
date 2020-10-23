package com.guiferrini.CasaCodigo.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CuponDuplicadoValidador implements Validator{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CuponDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//1
		if(errors.hasErrors()) {
			return;
		}
		//1
		CuponDTO cuponDTO = (CuponDTO) target;
		
		TypedQuery<String> consulta = entityManager.createQuery(
				"Select codigo " +
				"From Cupon " +
				"Where codigo=codigo",
				String.class
				);
		
		List<String> list = consulta.getResultList();
		//1
		if(list.contains(cuponDTO.getCodigo())) {
			errors.rejectValue("codigo", null, 
					"Já existe um Código com este mesmo nome " + cuponDTO.getCodigo());
		} 
	}	
}
