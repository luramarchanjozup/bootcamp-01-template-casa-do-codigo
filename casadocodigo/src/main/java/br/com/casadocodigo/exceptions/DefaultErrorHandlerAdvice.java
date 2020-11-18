package br.com.casadocodigo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class DefaultErrorHandlerAdvice {


    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<DefaultError> handleResponseStatusException(ResponseStatusException responseStatusException) {

        Collection<String> mensagens = new ArrayList<>();

        mensagens.add(responseStatusException.getReason());
        DefaultError erroPadronizado = new DefaultError(mensagens);

        return ResponseEntity.status(responseStatusException.getStatus()).body(erroPadronizado);

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultError> handle(MethodArgumentNotValidException methodArgumentNotValidException) {

        Collection<String> messages = new ArrayList<>();

        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        fieldErrors.forEach(fieldError -> {
            String message = String.format("Campo: %s \n Mensagem: %s", fieldError.getField(), fieldError.getDefaultMessage());
            messages.add(message);
        });

        DefaultError defaultError = new DefaultError(messages);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(defaultError);

    }

}
