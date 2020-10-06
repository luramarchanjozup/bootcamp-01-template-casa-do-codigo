package br.com.zup.treinocasadocodigo.validators;

import br.com.zup.treinocasadocodigo.entities.ErroPadronizado;
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

/**
 * Contagem de carga intrínseca da classe: 2
 */

@RestControllerAdvice
public class ValidacaoHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroPadronizado> handle(MethodArgumentNotValidException methodArgumentNotValidException) {
        Collection<String> mensagens = new ArrayList<>();
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        // 1
        fieldErrors.forEach(fieldError -> {
            String message = String.format("Campo %s %s", fieldError.getField(), fieldError.getDefaultMessage());
            mensagens.add(message);
        });

        // 1
        ErroPadronizado erroPadronizado = new ErroPadronizado(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadronizado);
    }
}