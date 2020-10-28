package com.apicasadocodigo.casadocodigo.service.validator;

import com.apicasadocodigo.casadocodigo.request.AuthorRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Component
public class ValidateUniqueEmail implements Validator {

   // @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return AuthorRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        if(errors.hasErrors()){
            return;
        }

        AuthorRequest isValidAuthorRequest = (AuthorRequest) object;

        Query query =  manager.createNativeQuery("SELECT a.email FROM category as c " +
                "WHERE a.email = :email" +
                "LIMIT 1;");

        query.setParameter("email",isValidAuthorRequest.getEmail());

        boolean exists =  query.getResultList().contains(isValidAuthorRequest.getEmail());

        if (exists){

            String massage = String.format("the email %s is associate with an Author. Please input another email address.",
                    isValidAuthorRequest.getEmail());

            errors.reject("email", null, massage);
        }

    }
}
