package com.github.marcoscoutozup.casadocodigo.fluxocompra.pedido;

import com.github.marcoscoutozup.casadocodigo.fluxocompra.itempedido.ItemPedido;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.itempedido.ItemPedidoDTO;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoDTO {

    @NotNull
    @Positive
    private BigDecimal total;

    @NotEmpty
    @Valid          //1
    private List<ItemPedidoDTO> itens;

            //2
    public Pedido toModel(EntityManager entityManager){
        return new Pedido(total, converteListaDeItensDePedido(entityManager));
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemPedidoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }

    public PedidoDTO(@NotNull @Positive BigDecimal total, @NotEmpty @Valid List<ItemPedidoDTO> itens) {
        this.total = total;
        this.itens = itens;
    }

    private List<ItemPedido> converteListaDeItensDePedido(EntityManager entityManager){
        //3
        return itens.stream().map(item -> item.toModel(entityManager)).collect(Collectors.toList());
    }
}
