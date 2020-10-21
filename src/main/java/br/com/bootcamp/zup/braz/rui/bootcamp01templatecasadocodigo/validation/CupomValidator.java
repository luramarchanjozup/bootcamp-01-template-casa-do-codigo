package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Cupom;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.repositories.CupomRepository;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.NovaCompraRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CupomValidator implements Validator {

    @Autowired
    CupomRepository cupomRepository; //1

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaCompraRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if (errors.hasErrors()) return; //1

        NovaCompraRequest novaCompraRequest = (NovaCompraRequest) object; //1
        Optional<Integer> idCupomInserido = novaCompraRequest.getIdCupom();
        if (idCupomInserido.isPresent()){ //1
            Cupom cupom = cupomRepository.getOne(idCupomInserido.get()); //1
            if (!cupom.isValido()){ //1
                errors.rejectValue("id", null, "Esta cupom está inválido.");
            }
        }

    }
}
