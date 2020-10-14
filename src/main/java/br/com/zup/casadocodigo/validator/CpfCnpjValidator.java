package br.com.zup.casadocodigo.validator;

import br.com.zup.casadocodigo.domain.Country;
import br.com.zup.casadocodigo.domain.State;
import br.com.zup.casadocodigo.dto.BuyerDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CpfCnpjValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BuyerDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        BuyerDTO buyerDTO = (BuyerDTO) target;
        if(!buyerDTO.validatesCpfCnpj()) {
            errors.reject("document", null, "document must be cpf or cnpj");
        }

    }
}
