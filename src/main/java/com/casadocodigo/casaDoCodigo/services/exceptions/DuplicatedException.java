package com.casadocodigo.casaDoCodigo.services.exceptions;

public class DuplicatedException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public DuplicatedException(String msg) {
        super(msg);
    }
}
