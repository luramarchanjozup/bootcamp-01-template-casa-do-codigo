package br.com.zup.casadocodigo.utils;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class ValidationErrorHandler {
    @Autowired
    private MessageSource messageSource;


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorsOutputDto handleValidationError(MethodArgumentNotValidException exception) {
        List<ObjectError> globalErrorList = exception.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrorList = exception.getBindingResult().getFieldErrors();
        return buildValidationError(globalErrorList, fieldErrorList);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ValidationErrorsOutputDto handleValidationError(BindException exception) {
        List<ObjectError> globalErrorList = exception.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrorList = exception.getBindingResult().getFieldErrors();
        return buildValidationError(globalErrorList, fieldErrorList);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ValidationErrorsOutputDto handleValidationError(HttpMessageNotReadableException exception) {
        InvalidFormatException invalidFormatException = (InvalidFormatException) exception.getCause();
        List<ObjectError> globalErrorList = List.of(new ObjectError("", invalidFormatException.getValue()+" não é um valor valido"));
        List<FieldError> fieldErrors = List.of();
        return buildValidationError(globalErrorList, fieldErrors);
    }

    private ValidationErrorsOutputDto buildValidationError(List<ObjectError> globalErrorList, List<FieldError> fieldErrorList) {
        ValidationErrorsOutputDto validationErrors = new ValidationErrorsOutputDto();
        //globalErrorList.forEach(error -> validationErrors.addError(error.toString()));
        fieldErrorList.forEach(error -> {
            String errorMessage = getErrorMessage(error);
            validationErrors.addFieldError(error.getField(), errorMessage);
        });
        return validationErrors;
    }

    private String getErrorMessage(FieldError error) {
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }
}
