package com.casadocodigo.casaDoCodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CartItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long bookId;
    @NotNull
    private Integer quantity;

    @Deprecated
    public CartItem(){}

    public CartItem(Long bookId, Integer quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public Long getId() {
        return this.id;
    }

    public Long getBook() {
        return this.bookId;
    }

    public void setBook(Long book) {
        this.bookId = book;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
