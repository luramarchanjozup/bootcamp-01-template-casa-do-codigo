package br.com.zup.treinocasadocodigo.validators.validarcompras;

import br.com.zup.treinocasadocodigo.entities.compra.CompraRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Contagem de carga intrínseca da classe: 6
 */

@Component
public class CompraValidador implements Validator {

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

        //2
        if(!EstadoValidador.estadoValido(compra, manager)) {
            errors.rejectValue("idEstado","Compra.estado","este estado não é do país selecionado");
        }

        //2
        if(!TotalValorValidador.totalValido(compra, manager)){
            errors.rejectValue("pedido.total","Compra.pedido.total","não está calculado corretamente");
        }


    }
}
