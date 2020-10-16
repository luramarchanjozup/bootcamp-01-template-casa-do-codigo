package com.bootcamp.cdd.models;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Embeddable
public class Item {
    @ManyToOne @NotNull
    private Book livro;
    @Min(value = 1, message = "é necessario ter pelo menos um livro") private int quantidade;
    private BigDecimal preco;

    public Item(Book livro, @Min(value = 1, message = "é necessario ter pelo menos um livro") int quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
        this.preco = livro.getPreco();
    }

    public Item() {
    }

    public BigDecimal total() {
        return preco;
    }

    public Book getLivro() {
        return livro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
