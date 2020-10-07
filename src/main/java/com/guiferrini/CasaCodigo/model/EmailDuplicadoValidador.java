package com.guiferrini.CasaCodigo.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.guiferrini.CasaCodigo.repository.AutorRepository;

@Component
public class EmailDuplicadoValidador implements Validator {
	
	@Autowired
	private AutorRepository autorRepo;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorDTO.class.isAssignableFrom(clazz); //a classe que eu aceito: qq q seja = ou filha de novo Autor
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		//caso tenha erro não executa
		if(errors.hasErrors()) {
			return;
		}  
			
		//valida se email é duplicado
		AutorDTO autor = (AutorDTO) target; 

		Optional<Autor> validando = autorRepo.findByEmail(autor.getEmail());
			
		if (validando.isPresent()) {
			errors.rejectValue("email", null,
				"Já existe um(a) outro(a) autor(a) com o mesmo email "
							+ autor.getEmail());
		}
	}
}
