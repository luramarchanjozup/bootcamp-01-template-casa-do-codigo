package com.itau.cdc.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.itau.cdc.DTO.EstadoRequest;
import com.itau.cdc.Repository.EstadoJpaRepository;
import com.itau.cdc.model.Estado;

@Component
public class ProibeEstadoDuplicadoValidator implements Validator {

	@Autowired
	private EstadoJpaRepository estadoJpaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return EstadoRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		EstadoRequest request = (EstadoRequest) target;
		
		Optional<Estado> possivelEstado = estadoJpaRepository.findByNome(request.getNome());
		
		if(possivelEstado==null) {
			errors.rejectValue("email", null,"Já existe um outro estado com o mesmo nome " + request.getNome());
		}
	}

}
