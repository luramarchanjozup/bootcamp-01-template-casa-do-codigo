package br.com.zup.bootcamp.controller.handler;

import br.com.zup.bootcamp.controller.model.GenericResponse;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Intrinsic charge = 2
@RestControllerAdvice
public class ArgumentNotValidHandler {

    // Catch Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponse> handle(MethodArgumentNotValidException exception){
        Collection<String> messages = new ArrayList<>();
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        // Create error messages and add on messages collection
        fieldErrors.forEach(fieldError -> {
            String message = String.format("%s", fieldError.getDefaultMessage());
            messages.add(message);
        });

        GenericResponse response = new GenericResponse(messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
