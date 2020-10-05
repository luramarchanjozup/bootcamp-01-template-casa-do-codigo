package com.bootcamp.cdd.validators;


import com.bootcamp.cdd.models.Author;
import com.bootcamp.cdd.repositories.AuthorRepository;
import com.bootcamp.cdd.request.AuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class DuplicatedEmailValidator implements Validator {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public boolean supports(@NonNull Class<?> aClass) {
        return AuthorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(@NonNull Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        AuthorRequest request = (AuthorRequest) o;
        Optional<Author> authorOptional = authorRepository.findByEmail(request.getEmail());
        if (authorOptional.isPresent()) {
            errors.rejectValue("email", "", "email: "+request.getEmail()+" já existe!");
        }
    }
}
