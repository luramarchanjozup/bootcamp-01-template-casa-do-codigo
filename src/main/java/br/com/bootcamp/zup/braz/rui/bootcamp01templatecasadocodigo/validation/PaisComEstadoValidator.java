package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Estado;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Pais;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.NovaCompraRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PaisComEstadoValidator implements Validator {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaCompraRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object objeto, Errors errors) {
        if (errors.hasErrors()) return;

        NovaCompraRequest novaCompraRequest = (NovaCompraRequest) objeto;

        Pais pais = entityManager.find(Pais.class, novaCompraRequest.getIdPais());
        Estado estado = entityManager.find(Estado.class, novaCompraRequest.getIdEstado());

        if (!estado.pertenceAPais(pais)){
            errors.rejectValue("idEstado", null, "Este estado não está associado ao país selecionado");
        }
    }
}
