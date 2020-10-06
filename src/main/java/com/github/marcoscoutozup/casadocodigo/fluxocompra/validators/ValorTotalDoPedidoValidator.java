package com.github.marcoscoutozup.casadocodigo.fluxocompra.validators;

import com.github.marcoscoutozup.casadocodigo.fluxocompra.compra.CompraDTO;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.pedido.PedidoDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ValorTotalDoPedidoValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> aClass) {
        return CompraDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        //1
        if(errors.hasErrors()){
            return;
        }
        //2
        CompraDTO compraDTO = (CompraDTO) o;

        //3
        if(compraDTO.toModel(entityManager).verificarSeTotalDoPedidoEIgualAoTotalRecebido()){
            errors.rejectValue( "pedido.total", null,"O valor do total não é compatível com o valor do banco");
        }
    }
}
