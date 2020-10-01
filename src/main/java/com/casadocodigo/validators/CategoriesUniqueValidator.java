package com.casadocodigo.validators;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.casadocodigo.entity.Categories;
import com.casadocodigo.repository.CategoriesRepository;
import com.casadocodigo.requests.CategoriesRequest;

@Component
public class CategoriesUniqueValidator implements Validator {

	@Autowired
	private CategoriesRepository categoryRepository;

	public boolean supports(Class<?> theclass) {
		return CategoriesRequest.class.isAssignableFrom(theclass);
	}

	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		CategoriesRequest request = (CategoriesRequest) target;

		Optional<Categories> categoryToValidate = categoryRepository.findByName(request.getName());

		if (categoryToValidate.isPresent()) {
			errors.rejectValue("name", null, "Já existe uma categoria com esse nome cadastrada " + request.getName());
		}
	}

}
