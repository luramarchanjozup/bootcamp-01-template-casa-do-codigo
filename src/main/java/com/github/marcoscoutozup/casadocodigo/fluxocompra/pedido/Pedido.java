package com.github.marcoscoutozup.casadocodigo.fluxocompra.pedido;

import com.github.marcoscoutozup.casadocodigo.fluxocompra.itempedido.ItemPedido;
import com.github.marcoscoutozup.casadocodigo.livro.Livro;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

@Embeddable
public class Pedido {

    @NotNull
    @Positive
    private BigDecimal total;

    @ElementCollection
    @NotEmpty
    @Valid //1
    private List<ItemPedido> itens;

    @Deprecated
    public Pedido() {
    }

    public Pedido(@NotNull @Positive BigDecimal total, @NotEmpty @Valid List<ItemPedido> itens) {
        this.total = total;
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "total=" + total +
                ", itens=" + itens +
                '}';
    }



}
