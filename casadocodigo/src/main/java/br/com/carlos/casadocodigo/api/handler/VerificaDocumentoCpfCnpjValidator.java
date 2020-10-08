package br.com.carlos.casadocodigo.api.handler;

import br.com.carlos.casadocodigo.api.dto.RequestCompraDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VerificaDocumentoCpfCnpjValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RequestCompraDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return ;
        }

        RequestCompraDto request = (RequestCompraDto) target;
        if(!request.documentoValido()) {
            errors.rejectValue("documento",null, "documento precisa ser cpf ou cnpj");
        }
    }
}
