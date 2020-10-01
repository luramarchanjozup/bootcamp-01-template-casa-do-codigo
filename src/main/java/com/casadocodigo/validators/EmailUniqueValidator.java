package com.casadocodigo.validators;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.casadocodigo.entity.Author;
import com.casadocodigo.repository.AuthorRepository;
import com.casadocodigo.requests.AuthorRequest;

@Component
public class EmailUniqueValidator implements Validator {

	@Autowired
	private AuthorRepository authorRepository;

	public boolean supports(Class<?> theclass) {
		return AuthorRequest.class.isAssignableFrom(theclass);
	}

	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		AuthorRequest request = (AuthorRequest) target;

		Optional<Author> authorToValidate = authorRepository.findByEmail(request.getEmail());

		if (authorToValidate.isPresent()) {
			errors.rejectValue("email", null,
					"Já existe um(a) outro(a) com esse email cadastrado " + request.getEmail());
		}
	}

}
