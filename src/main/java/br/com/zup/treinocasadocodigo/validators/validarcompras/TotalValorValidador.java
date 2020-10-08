package br.com.zup.treinocasadocodigo.validators.validarcompras;


import br.com.zup.treinocasadocodigo.entities.compra.CompraRequest;
import br.com.zup.treinocasadocodigo.entities.compra.ItensCompraRequest;
import br.com.zup.treinocasadocodigo.entities.livro.Livro;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

/**
 * Contagem de carga intrínseca da classe: 6
 */

@Component
public class TotalValorValidador implements Validator {

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

        BigDecimal valorTotal = compra.getPedido().getTotal();

        BigDecimal valorCalculado = new BigDecimal("0");

        //2
        for(ItensCompraRequest item : compra.getPedido().getItens()) {
            //1
            Livro livro = manager.find(Livro.class,item.getIdLivro());
            BigDecimal valorItem = livro.getPreco().multiply(new BigDecimal(item.getQuantidade()));
            valorCalculado = valorCalculado.add(valorItem);
        }

        //1
        if((valorTotal.compareTo(valorCalculado) != 0)){
            errors.rejectValue("pedido.total","Compra.pedido.total","não está calculado corretamente");
        }
    }
}
