package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Estado;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Pais;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.NovaCompraRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class PaisComEstadoValidator implements Validator {

    @PersistenceContext
    EntityManager entityManager;

    @Override //1
    public boolean supports(Class<?> aClass) {
        return NovaCompraRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object objeto, Errors errors) {
        if (errors.hasErrors()) { //1
            return;
        }

        NovaCompraRequest novaCompraRequest = (NovaCompraRequest) objeto;

        if (novaCompraRequest.temEstado()) {
            Pais pais = entityManager.find(Pais.class, novaCompraRequest.getIdPais()); //1
            Estado estado = entityManager.find(Estado.class, novaCompraRequest.getIdEstado()); //1

            if (!estado.pertenceAPais(pais)){
                errors.rejectValue("idEstado", null, "Este estado não está associado ao país selecionado");
        }
        }
    }
}
