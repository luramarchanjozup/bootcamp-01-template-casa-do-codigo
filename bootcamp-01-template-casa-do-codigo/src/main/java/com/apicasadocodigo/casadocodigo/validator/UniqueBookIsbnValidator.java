package com.apicasadocodigo.casadocodigo.validator;

import com.apicasadocodigo.casadocodigo.model.Book;
import com.apicasadocodigo.casadocodigo.request.BookRequest;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UniqueBookIsbnValidator implements Validator {

    @Autowired
    private GenericDAO genericDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return BookRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        BookRequest bookRequest = (BookRequest) object;

        boolean exists = genericDAO
                        .findEntityByAtribute(Book.class, "isbn", bookRequest.getIsbn());

        if(!exists){
            errors.reject("isbn", null, "Já existe um livro com o isbn "
            + bookRequest.getIsbn());
        }
    }
}