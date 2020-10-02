package com.github.marcoscoutozup.casadocodigo.fluxocompra.itempedido;

import com.github.marcoscoutozup.casadocodigo.livro.Livro;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Embeddable
public class ItemPedido {

    @NotNull
    @ManyToOne //1
    private Livro livro;

    @NotNull
    @Positive
    private Integer quantidade;

    @Deprecated
    public ItemPedido() {
    }

    public ItemPedido(@NotNull Livro livro, @NotNull @Positive Integer quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
    }

    public Livro getLivro() {
        return livro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "livro=" + livro +
                ", quantidade=" + quantidade +
                '}';
    }
}
