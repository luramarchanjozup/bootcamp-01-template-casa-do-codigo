package br.com.casacodig.error;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Contagem de Pontos - TOTAL:2
//1 - ApiErroException
//1 - ErroPadronizado

@RestControllerAdvice
public class ApiHandlerAdvice {
	
	@ExceptionHandler({
		ApiErroException.class,
		ValidationException.class
	 })
	//@ExceptionHandler(ApiErroException.class)
	public ResponseEntity<ErroPadronizado> handleApiErroException(ApiErroException apiErroException) {
	    Collection<String> mensagens = new ArrayList<>();
	    mensagens.add(apiErroException.getReason());

	    ErroPadronizado erroPadronizado = new ErroPadronizado(mensagens);
	    return ResponseEntity.status(apiErroException.getHttpStatus()).body(erroPadronizado);
	}

}
