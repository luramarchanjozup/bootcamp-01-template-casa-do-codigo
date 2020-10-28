package com.apicasadocodigo.casadocodigo.exception;

import com.apicasadocodigo.casadocodigo.model.Author;

public class AuthorNotFoundException extends EntityNotFoundException {

    public AuthorNotFoundException(Long id){
        super(Author.class , id.toString());
    }

}
