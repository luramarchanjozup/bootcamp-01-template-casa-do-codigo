package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation;

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

@RestControllerAdvice
public class MeuHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroParonizado> handle(MethodArgumentNotValidException methodArgumentNotValidException) {
        Collection<String> mensagens = new ArrayList<>();
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            String message = String.format("Falha: Valor de '%s' %s", fieldError.getField().toUpperCase(), fieldError.getDefaultMessage());
            mensagens.add(message);
        });
        ErroParonizado erroParonizado = new ErroParonizado(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroParonizado);
    }
}
