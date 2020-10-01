package com.casadocodigo.casaDoCodigo.config;

import com.casadocodigo.casaDoCodigo.services.exceptions.ObjectNotFoundException;
import com.casadocodigo.casaDoCodigo.services.exceptions.PurchaseException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CasaDoCodigoExceptionHandler {
    
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ObjectNotFoundException.class)
    public String objectNotFoundHandler(ObjectNotFoundException e) {
        return "Error 400: \n\nMessage: " + e.getMessage();
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String notValidHandler(MethodArgumentNotValidException e) {
        return "Error 400: \n\nMessage: Error on field " + e.getBindingResult().getFieldError().getField().toString() +
                "\n" + e.getBindingResult().getFieldError().getDefaultMessage();
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String missingRequestParameterHandler(MissingServletRequestParameterException e) {
        return "Error 400: \n\nMessage: Parameter " + e.getParameterName().toString() + " must not be empty";
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PurchaseException.class)
    public String PurchaseExceptionHandler(PurchaseException e) {
        return "Error 400: \n\nMessage: " + e.getMessage().toString();
    }
}
