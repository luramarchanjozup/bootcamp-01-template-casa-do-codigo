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
 * Contagem de carga intrínseca da classe: 5
 */

@Component
public class EstadoValidador implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return CompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //1
        if(errors.hasErrors()) {
            return;
        }

        //1
        CompraRequest dadosComprador = (CompraRequest) o;

        //1
        if (dadosComprador.getIdEstado() == null) {
            return;
        }

        //1
        Pais pais = manager.find(Pais.class, dadosComprador.getIdPais());
        Estado estado = manager.find(Estado.class, dadosComprador.getIdEstado());

        //1
        if(!estado.pertenceAPais(pais)) {
            errors.rejectValue("idEstado","Comprador.estado","este estado não é o do país selecionado");
        }

    }
}
