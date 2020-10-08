package com.itau.cdc.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.itau.cdc.DTO.ErroPadronizado;
import com.itau.cdc.configuration.exception.ApiErroException;

@RestControllerAdvice
//2
public class HandleAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	//1
	public ResponseEntity<ErroPadronizado> handle(MethodArgumentNotValidException methodArgumentNotValidException){
		
		Collection<String> mensagens = new ArrayList<>();
		BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		
		fieldErrors.forEach(fieldError -> {
            String message = String.format("Campo %s %s", fieldError.getField(), fieldError.getDefaultMessage());
            mensagens.add(message);
        });
		
		ErroPadronizado erroPadronizado = new ErroPadronizado(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadronizado);
		
	}
	
	@ExceptionHandler(ApiErroException.class)
	//1
	public ResponseEntity<ErroPadronizado> handleApiErroException(ApiErroException apiErroException) {
	    Collection<String> mensagens = new ArrayList<>();
	    mensagens.add(apiErroException.getReason());

	    ErroPadronizado erroPadronizado = new ErroPadronizado(mensagens);
	    return ResponseEntity.status(apiErroException.getHttpStatus()).body(erroPadronizado);
	}
	
}
