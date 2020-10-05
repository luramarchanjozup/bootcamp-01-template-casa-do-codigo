package br.com.casadocodigo.models;

import javax.persistence.Embeddable;

@Embeddable
public class Item {

    private Long bookId;

    private Long quantity;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
