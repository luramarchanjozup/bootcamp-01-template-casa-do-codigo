package br.com.zup.bootcamp.controller.handler;

import br.com.zup.bootcamp.controller.exception.EmailAlreadyExistException;
import br.com.zup.bootcamp.controller.model.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Intrinsic charge = 2
@RestControllerAdvice
public class EmailAlreadyExistHandler {

    // Catch Email Already Exist Exception
    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<GenericResponse> handle(EmailAlreadyExistException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new GenericResponse("Email already exist", 422));
    }
}
