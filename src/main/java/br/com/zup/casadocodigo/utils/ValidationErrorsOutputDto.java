package br.com.zup.casadocodigo.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ValidationErrorsOutputDto {

    private final List<FieldErrorOutputDto> fieldErrorsList = new ArrayList<>();

    public void addFieldError (String field, String message) {
        FieldErrorOutputDto fieldError = new FieldErrorOutputDto(field, message);
        fieldErrorsList.add(fieldError);
    }

    public List<FieldErrorOutputDto> getFieldErrorsList() {
        return fieldErrorsList;
    }

}
