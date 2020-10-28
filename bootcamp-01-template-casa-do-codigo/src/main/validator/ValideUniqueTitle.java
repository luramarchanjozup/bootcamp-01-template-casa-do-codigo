package com.apicasadocodigo.casadocodigo.service.validator;

import com.apicasadocodigo.casadocodigo.request.BookRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.Query;


@Component
public class ValideUniqueTitle implements Validator {

   // @Future
   // @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return  BookRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        if(errors.hasErrors()){
            return ;
        }

        BookRequest book = (BookRequest) o;

        Query query =  manager.createNativeQuery("SELECT b.title FROM book as b " +
                                                    "WHERE b.title = :title " +
                                                    "LIMIT 1;");

        query.setParameter("title", book.getTitle());

        if (query.getResultList().size() > 0) {

            String massage = String.format("The %s book already exists. Please, input another book.",
                    book.getTitle());

            errors.reject("title", null, massage);

        }

    }
}
