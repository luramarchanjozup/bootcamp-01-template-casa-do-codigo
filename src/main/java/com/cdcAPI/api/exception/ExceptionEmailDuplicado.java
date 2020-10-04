package com.cdcAPI.api.exception;

import java.util.Optional;

import com.cdcAPI.api.model.AutorRequest;
import com.cdcAPI.model.Autor;
import com.cdcAPI.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

    @Component
    public class ExceptionEmailDuplicado implements Validator {

        @Autowired
        private AutorRepository autorRepository;

        @Override
        public boolean supports(Class<?> clazz) {
            return AutorRequest.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            if (errors.hasErrors()) {
                return;
            }

            AutorRequest request = (AutorRequest) target;

            Optional<Autor> possivelAutor = autorRepository
                    .findByEmail(request.getEmail());

            if (possivelAutor.isPresent()) {
                errors.rejectValue("email", null,
                        "Já existe autor(a) com o mesmo email "
                                + request.getEmail());
            }
        }

    }