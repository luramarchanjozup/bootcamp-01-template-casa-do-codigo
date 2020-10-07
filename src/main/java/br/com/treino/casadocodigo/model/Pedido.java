package br.com.treino.casadocodigo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Positive
    private BigDecimal total;
    @Size(min = 1)
    private Set<ItemPedido> itemPedidos;

    @Deprecated
    public Pedido(){}

    public Pedido(Set<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    public BigDecimal getTotal() {

        //itemPedidos.stream().map(i -> i.valorTotal()).reduce(
        //        BigDecimal.ZERO, (s1, s2) -> s1.add(s2));

        BigDecimal acc = BigDecimal.ZERO;
        for (ItemPedido i : itemPedidos) {
            BigDecimal bigDecimal = i.valorTotal();
            acc = acc.add(bigDecimal);
        }
        total = acc;
        return total;
    }

    public Set<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }


}
