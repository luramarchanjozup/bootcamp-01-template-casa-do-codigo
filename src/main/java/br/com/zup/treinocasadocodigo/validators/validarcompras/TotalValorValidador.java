package br.com.zup.treinocasadocodigo.validators.validarcompras;


import br.com.zup.treinocasadocodigo.entities.compra.CompraNovoRequest;
import br.com.zup.treinocasadocodigo.entities.compra.itemcompra.ItemCompraNovoRequest;
import br.com.zup.treinocasadocodigo.entities.cupom.Cupom;
import br.com.zup.treinocasadocodigo.entities.livro.Livro;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

/**
 * Contagem de carga intrínseca da classe: 6
 */

public class TotalValorValidador{

    //1
    public static boolean totalValido(CompraNovoRequest compra, EntityManager manager) {

        BigDecimal valorTotal = compra.getPedido().getTotal();

        BigDecimal valorCalculado = new BigDecimal("0");

        //2
        for(ItemCompraNovoRequest item : compra.getPedido().getItens()) {
            //1
            Livro livro = manager.find(Livro.class,item.getIdLivro());
            BigDecimal valorItem = livro.getPreco().multiply(new BigDecimal(item.getQuantidade()));
            valorCalculado = valorCalculado.add(valorItem);
        }

        //1
        List< Cupom > listaCupons =  manager
                .createQuery("SELECT c FROM Cupom c WHERE c.codigo = :codigo", Cupom.class)
                .setParameter("codigo", compra.getPedido().getCodigoCupom())
                .setMaxResults(1)
                .getResultList();
        //1
        if (!listaCupons.isEmpty()) {
            Assert.isTrue(listaCupons.size() <= 1, "Não deveria haver dois codigos iguais");

            BigDecimal porcentagemDesconto = listaCupons.get(0).getDesconto();
            BigDecimal valorDesconto = valorCalculado.multiply(porcentagemDesconto);
            valorCalculado = valorCalculado.subtract(valorDesconto);
        }

        return (valorTotal.compareTo(valorCalculado) == 0);
    }
}
