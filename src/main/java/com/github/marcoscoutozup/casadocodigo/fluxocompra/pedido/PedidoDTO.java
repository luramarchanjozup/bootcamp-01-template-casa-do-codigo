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
    @Valid //1
    private List<ItemPedidoDTO> itens;

    public Pedido toModel(EntityManager entityManager){
        return new Pedido(total, converteListaDeItensDePedido(itens, entityManager));
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

    //2
    private List<ItemPedido> converteListaDeItensDePedido(List<ItemPedidoDTO> itens, EntityManager entityManager){
        return itens.stream().map(item -> item.toModel(entityManager)).collect(Collectors.toList());
    }

    public boolean validarTotalDoPedido(BigDecimal totalDaCompra, EntityManager entityManager){

        //3
        BigDecimal totalDoBanco = itens.stream()
                .map(item ->
                        item.buscarLivro(entityManager).getPreco().multiply(new BigDecimal(item.getQuantidade())))
                .reduce(new BigDecimal(0), BigDecimal::add);

        return totalDoBanco.compareTo(totalDaCompra) != 0;

    }
}
