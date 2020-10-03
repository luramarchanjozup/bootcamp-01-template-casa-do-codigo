package com.itau.cdc.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.itau.cdc.DTO.NovoAutorRequest;
import com.itau.cdc.Repository.AutorJpaRepository;
import com.itau.cdc.model.Autor;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

	@Autowired
	private AutorJpaRepository autorJpaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoAutorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		NovoAutorRequest request = (NovoAutorRequest) target;

		Optional<Autor> possivelAutor = autorJpaRepository.findByEmail(request.getEmail());

		if (possivelAutor.isPresent()) {
			errors.rejectValue("email", null,
					"Já existe um(a) outro(a) autor(a) com o mesmo email " + request.getEmail());
		}
	}

}
