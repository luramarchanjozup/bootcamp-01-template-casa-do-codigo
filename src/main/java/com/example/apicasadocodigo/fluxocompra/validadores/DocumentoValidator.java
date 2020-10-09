package com.example.apicasadocodigo.fluxocompra.validadores;

import com.example.apicasadocodigo.fluxocompra.compra.NovaCompraRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DocumentoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NovaCompraRequest request = (NovaCompraRequest) target;

        if (!request.documentoValido()) {
            errors.rejectValue("documento", null, "CPF ou CNPJ precisa ser válido.");
        }
    }
}