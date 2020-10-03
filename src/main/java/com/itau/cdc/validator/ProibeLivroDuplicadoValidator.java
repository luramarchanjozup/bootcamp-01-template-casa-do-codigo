package com.itau.cdc.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.itau.cdc.DTO.LivroRequest;
import com.itau.cdc.Repository.LivroJpaRepository;
import com.itau.cdc.model.Livro2;

@Component
public class ProibeLivroDuplicadoValidator implements Validator {

	@Autowired
	private LivroJpaRepository livroJpaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return LivroRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		LivroRequest request = (LivroRequest) target;
		
		Optional<Livro2> possivelLivro = livroJpaRepository.findByTitulo(request.getTitulo());
		
		if (possivelLivro.isPresent()) {
			errors.rejectValue("email", null,
					"Já existe um outro livro com o mesmo titulo " + request.getTitulo());
		}
	}

}
