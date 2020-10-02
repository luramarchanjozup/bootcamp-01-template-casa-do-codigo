package com.itau.cdc.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.itau.cdc.Repository.CategoriaJpaRepository;
import com.itau.cdc.model.Categoria;
import com.itau.cdc.model.DTO.NovaCategoriaRequest;

@Component
public class ProibeCategoriaDuplicadaValidator implements Validator {

	@Autowired
	private CategoriaJpaRepository categoriaJpaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		NovaCategoriaRequest request = (NovaCategoriaRequest) target;
		
		Optional<Categoria> possivelCategoria = categoriaJpaRepository.findByNome(request.getNome());
		
		if (possivelCategoria.isPresent()) {
			errors.rejectValue("categoria", null,
					"Já existe uma outra categoria com o mesmo nome " + request.getNome());
		}
	}
	
	
	
}
