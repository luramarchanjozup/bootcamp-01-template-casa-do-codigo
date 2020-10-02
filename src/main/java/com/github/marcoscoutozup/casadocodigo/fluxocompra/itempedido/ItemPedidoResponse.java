package com.github.marcoscoutozup.casadocodigo.fluxocompra.itempedido;

import java.math.BigDecimal;

public class ItemPedidoResponse {

    private String tituloDoLivro;
    private BigDecimal preco;
    private Integer quantidade;

                                //1
    public ItemPedidoResponse(ItemPedido itemPedido) {
        this.tituloDoLivro = itemPedido.getLivro().getTitulo();
        this.preco = itemPedido.getLivro().getPreco();
        this.quantidade = itemPedido.getQuantidade();
    }

    public String getTituloDoLivro() {
        return tituloDoLivro;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
