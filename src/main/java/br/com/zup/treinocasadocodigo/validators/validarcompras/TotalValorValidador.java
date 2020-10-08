package br.com.zup.treinocasadocodigo.validators.validarcompras;


import br.com.zup.treinocasadocodigo.entities.compra.CompraRequest;
import br.com.zup.treinocasadocodigo.entities.compra.itemcompra.ItemCompraRequest;
import br.com.zup.treinocasadocodigo.entities.livro.Livro;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

/**
 * Contagem de carga intrínseca da classe: 4
 */

public class TotalValorValidador{

    //1
    public static boolean totalValido(CompraRequest compra, EntityManager manager) {

        BigDecimal valorTotal = compra.getPedido().getTotal();

        BigDecimal valorCalculado = new BigDecimal("0");

        //2
        for(ItemCompraRequest item : compra.getPedido().getItens()) {
            //1
            Livro livro = manager.find(Livro.class,item.getIdLivro());
            BigDecimal valorItem = livro.getPreco().multiply(new BigDecimal(item.getQuantidade()));
            valorCalculado = valorCalculado.add(valorItem);
        }

        return (valorTotal.compareTo(valorCalculado) == 0);
    }
}
