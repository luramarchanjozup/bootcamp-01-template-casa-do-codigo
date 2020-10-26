package br.com.casadocodigo.validator;

import br.com.casadocodigo.model.NovaCompraRequest;
import org.springframework.validation.Errors;

import javax.validation.Validator;

public class VerificaDocumentoCpfCnpjValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return ;
        }

        NovaCompraRequest request = (NovaCompraRequest) target;
        if(!request.documentoValido()) {
            errors.rejectValue("documento",null, "documento precisa ser válido");
        }
    }
}
