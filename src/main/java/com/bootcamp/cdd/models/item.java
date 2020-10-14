package com.bootcamp.cdd.models;

import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;


public class item {
    @ManyToOne
    private long id;
    private Book livro;
    @Min(value = 1, message = "é necessario ter pelo menos um livro") private int Quantidade;

    public item(long id, Book livro, @Min(value = 1, message = "é necessario ter pelo menos um livro") int quantidade) {
        this.id = id;
        this.livro = livro;
        Quantidade = quantidade;
    }

    public item() {
    }
}
