package com.example.apicasadocodigo.fluxocompra.validadores;

import com.example.apicasadocodigo.fluxocompra.compra.NovaCompraRequest;
import com.example.apicasadocodigo.fluxocompra.cupom.Cupom;
import com.example.apicasadocodigo.fluxocompra.cupom.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CupomValidator implements Validator {
    @Autowired
    CupomRepository cupomRepository;

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
        Optional<String> possivelCodigo = request.getCodigoCupom();
        if (possivelCodigo.isPresent()) {
            Cupom cupom = cupomRepository.findByCodigo(possivelCodigo.get());
            if (!cupom.valido()) {
                errors.rejectValue("codigoCupom", null,
                        "Este cupom não é mais válido");
            }
        }
    }
}
