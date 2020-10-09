package br.com.treino.casadocodigo.validations;

import br.com.treino.casadocodigo.model.Cupom;
import br.com.treino.casadocodigo.repository.CupomRepositoy;
import br.com.treino.casadocodigo.request.NovaCompraRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CupomValidoValidator implements Validator {

    @Autowired
    CupomRepositoy cupomRepositoy; //¹

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCompraRequest.class.isAssignableFrom(clazz); //2
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        NovaCompraRequest request = (NovaCompraRequest) target;

        Optional<String> possivelcodigo = request.getCodigoCupom();

        if (possivelcodigo.isPresent()){ //3
            Cupom cupom = cupomRepositoy.getByCodigo(possivelcodigo.get()); //4
            if(!cupom.cupomValido()){ //5
                errors.rejectValue("codigoCupom",
                        null, "Esse cupom não é mais válido");
            }
        }


    }
}
