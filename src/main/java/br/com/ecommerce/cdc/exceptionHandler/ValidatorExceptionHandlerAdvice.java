package br.com.ecommerce.cdc.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Carga intrínseca máxima permitida na classe - 7
 * Carga intrínseca da classe - 3
 */

@RestControllerAdvice
public class ValidatorExceptionHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validatorsHandlerAdvice(MethodArgumentNotValidException exception){
        List<String> errors = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        // +2
        fieldErrors.forEach(fieldError -> {
            errors.add(String.format("%s %s" , fieldError.getField(), fieldError.getDefaultMessage()));
        });
        // +1
        ErrorMessage errorMessage = new ErrorMessage(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.toString(),
                exception.getParameter().toString(),
                errors,
                exception.getMessage());

        return ResponseEntity.badRequest().body(errorMessage);
    }

}
