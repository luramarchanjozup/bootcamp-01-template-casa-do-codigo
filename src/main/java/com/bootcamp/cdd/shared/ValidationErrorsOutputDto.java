package com.bootcamp.cdd.shared;

import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorsOutputDto {
    private final List<String> globalErrorMessagesList = new ArrayList<>();
    private final List<FieldErrorOutputDto> fieldErrorsList = new ArrayList<>();

    public void addError (String message) {
        globalErrorMessagesList.add(message);
    }

    public void addFieldError (String field, String message) {
        FieldErrorOutputDto fieldError = new FieldErrorOutputDto(field, message);
        fieldErrorsList.add(fieldError);
    }

    public List<String> getGlobalErrorMessagesList() {
        return globalErrorMessagesList;
    }

    public List<FieldErrorOutputDto> getFieldErrorsList() {
        return fieldErrorsList;
    }

    public int getNumberOfError () {
        return fieldErrorsList.size() + globalErrorMessagesList.size();
    }
}
