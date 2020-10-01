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
        CompraDTO compraDTO = (CompraDTO) o;
        PedidoDTO pedido = compraDTO.getPedido();

        if(pedido.validarTotalDoPedido(pedido.getTotal(), entityManager)){
            errors.rejectValue( "pedido.total", null,"O valor do total não é compatível com o valor do banco");
        }
    }
}
