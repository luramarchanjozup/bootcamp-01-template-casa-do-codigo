package com.apicasadocodigo.casadocodigo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private static final String message = "None %s has found with this %s.";

    public EntityNotFoundException(Class<?> entityName, String value) {
        super(String.format(message, entityName.getSimpleName(), value));
    }
}
