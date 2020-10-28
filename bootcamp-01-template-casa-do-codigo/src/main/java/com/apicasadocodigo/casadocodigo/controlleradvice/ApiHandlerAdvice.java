package com.apicasadocodigo.casadocodigo.controlleradvice;
import com.apicasadocodigo.casadocodigo.controlleradvice.error.PatternedError;
import com.apicasadocodigo.casadocodigo.controlleradvice.error.ValidationErrorsOutputDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class ApiHandlerAdvice {

    @Autowired
    private MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(ApiHandlerAdvice.class);

    /*vai executar este método quando os argumentos no corpo de uma requisição serem inválidos*/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<PatternedError> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {

        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();

        ValidationErrorsOutputDto validationErrorsOutputDto = buildValidationErrors(fieldErrors);

        return new ResponseEntity(validationErrorsOutputDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<PatternedError> handleResponseStatusException(ResponseStatusException responseStatusException){
        Collection <String> messages = new ArrayList<>();
        messages.add(responseStatusException.getReason());

        PatternedError patternedError = new PatternedError(messages);

        return ResponseEntity.status(responseStatusException.getStatus()).body(patternedError);
    }

    /*formata a apresentação des objetos ObjectError para um objeto ValidationErrorsOutputDto*/
    private ValidationErrorsOutputDto buildValidationErrors(List<FieldError> fieldsErrors) {

        ValidationErrorsOutputDto validationErrors = new ValidationErrorsOutputDto();


        /* Para cada objeto FieldError(encapsula um erro) na coleção o método  getErrorMessage é
        *  usado para resolver o erro através do MessageSource (presente no método getErrorMessage),
        *  em seguida o erro resolvido é adicionado a lista de erros o campo inválidado
        *  e o erro resolvidode.. */
        fieldsErrors.forEach(fe -> {
            String errorMessage = getErrorMessage(fe);
            validationErrors.addFieldError(fe.getField(), errorMessage);
        });

        return validationErrors;
    }

    /* Um objeto ObjectError encapsula um erro que é rasão principal da rejeição de um objeto. */
    private String getErrorMessage(ObjectError error){

        /*getMessage tenta resolver a mensagem usando os atributos no primeiro argumento
        * que foi passado. O segundo argumento é o local para ser feita a pesqeuisa*/
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }

}
