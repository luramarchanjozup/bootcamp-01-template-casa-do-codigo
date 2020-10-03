package com.itau.cdc.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.itau.cdc.DTO.PaisRequest;
import com.itau.cdc.Repository.PaisJpaRepository;
import com.itau.cdc.model.Pais;

@Component
public class ProibePaisDuplicadoValidator implements Validator {

	@Autowired
	private PaisJpaRepository paisJpsRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return PaisRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		PaisRequest request = (PaisRequest) target;
		
		Optional<Pais> possivelPais = paisJpsRepository.findByNome(request.getNome());
		
		if(possivelPais.isPresent()) {
			errors.rejectValue("email", null,
					"Já existe um outro pais com o mesmo nome " + request.getNome());
		}
		
	}

}
