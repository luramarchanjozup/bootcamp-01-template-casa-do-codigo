package com.bootcamp.cdd.request;

import com.bootcamp.cdd.models.Book;
import com.bootcamp.cdd.models.Item;
import com.bootcamp.cdd.shared.ExistsId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ItemRequest {
    @NotNull
    @ExistsId(fieldName = "id", domainClass = Book.class)
    private Long livroId;
    @Positive
    private int quantidade = 1;

    public ItemRequest(@NotNull long livroId, @Positive int quantidade) {
        this.livroId = livroId;
        //this.quantidade = quantidade;
    }

    public ItemRequest() {
    }

    public long getLivroId() {
        return livroId;
    }

    public Item toModel (EntityManager manager) {
        @NotNull Book livro = manager.find(Book.class, livroId);
        return new Item(livro, this.quantidade);
    }
}
