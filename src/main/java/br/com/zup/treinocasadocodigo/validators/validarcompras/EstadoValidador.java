package br.com.zup.treinocasadocodigo.validators.validarcompras;

import br.com.zup.treinocasadocodigo.entities.compra.CompraRequest;
import br.com.zup.treinocasadocodigo.entities.estado.Estado;
import br.com.zup.treinocasadocodigo.entities.pais.Pais;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Contagem de carga intrínseca da classe: 6
 */

@Component
public class EstadoValidador implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return CompraRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //1
        if(errors.hasErrors()) {
            return;
        }

        //1
        CompraRequest compra = (CompraRequest) o;

        //1
        if (compra.getIdEstado() == null) {
            return;
        }

        //1
        Pais pais = manager.find(Pais.class, compra.getIdPais());
        //1
        Estado estado = manager.find(Estado.class, compra.getIdEstado());

        //1
        if(!estado.pertenceAPais(pais)) {
            errors.rejectValue("idEstado","Compra.estado","este estado não é o do país selecionado");
        }

    }
}
