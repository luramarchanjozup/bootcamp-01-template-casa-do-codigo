package com.casadocodigo.casaDoCodigo.services.validators;

import java.util.Optional;

import com.casadocodigo.casaDoCodigo.controllers.form.AuthorForm;
import com.casadocodigo.casaDoCodigo.model.Author;
import com.casadocodigo.casaDoCodigo.repositories.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CheckDuplicatedEmail implements Validator {
    
    @Autowired
    private AuthorRepository authorRepositiory;

    @Override
    public boolean supports(Class<?> clazz) {
        return AuthorForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        AuthorForm request = (AuthorForm) target;

        Optional<Author> possibleAuthor = authorRepositiory.findByEmail(request.getEmail());

        if(possibleAuthor.isPresent()) {
            errors.rejectValue("email", null, 
                "A Author with the email " + request.getEmail() + " already exists");
        }
    }
}
