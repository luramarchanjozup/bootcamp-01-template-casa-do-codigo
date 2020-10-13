package io.github.evertoncnsouza.validation.constraint.valitation;


import io.github.evertoncnsouza.rest.dto.CompraRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VerificaDocumentoCpfCnpjValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return CompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        CompraRequest request = (CompraRequest) target;
        if(!request.documentoValido()) {
            errors.rejectValue("documento", null, "Necessário CPF ou CNPJ");
        }

    }
}
