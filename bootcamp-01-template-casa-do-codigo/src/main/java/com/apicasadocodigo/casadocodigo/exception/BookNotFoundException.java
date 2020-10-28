package com.apicasadocodigo.casadocodigo.exception;

import  com.apicasadocodigo.casadocodigo.model.Book;

public class BookNotFoundException extends EntityNotFoundException {

    public BookNotFoundException(Long id){
        super(Book.class, id.toString());
    }

}
