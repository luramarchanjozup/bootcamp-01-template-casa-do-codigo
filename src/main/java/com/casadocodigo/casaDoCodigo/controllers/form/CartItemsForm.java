package com.casadocodigo.casaDoCodigo.controllers.form;

public class CartItemsForm {
    private Long bookId;
    private Integer quantity;

    public Long getBookId() {
        return this.bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
