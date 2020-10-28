package com.apicasadocodigo.casadocodigo.model.purchase;


public class Item {

    private Long bookId;
    private Integer quantity;

    public Item(Long bookId, Integer quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public Long getBookId() {
        return bookId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
