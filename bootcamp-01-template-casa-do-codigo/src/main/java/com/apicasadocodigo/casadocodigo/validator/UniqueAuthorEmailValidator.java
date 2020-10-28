package com.apicasadocodigo.casadocodigo.validator;

import com.apicasadocodigo.casadocodigo.model.Author;
import com.apicasadocodigo.casadocodigo.request.AuthorRequest;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UniqueAuthorEmailValidator implements Validator {

    @Autowired
    private GenericDAO genericDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return AuthorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        AuthorRequest author = (AuthorRequest) object;

        boolean exists = genericDAO
                        .findEntityByAtribute(Author.class, "email", author.getEmail());

        if(!exists){
            errors.reject("email", null, "Já existe um(a) outro(a) com o mesmo email "
            + author.getEmail());
        }
    }
}