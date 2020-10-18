package io.github.evertoncnsouza.rest.dto;

import io.github.evertoncnsouza.domain.entity.ItemPedido;
import java.math.BigDecimal;

public class PedidoItemResponse {
    private Integer quantidade;
    private BigDecimal preco;
    private itemLivroDetalheResponse livro;

    public PedidoItemResponse(ItemPedido item) {
        livro = new itemLivroDetalheResponse(item.getLivro());
        preco = item.getPrecoMomento();
        quantidade = item.getQuantidade();
    }

    public itemLivroDetalheResponse getLivro() {
        return livro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}