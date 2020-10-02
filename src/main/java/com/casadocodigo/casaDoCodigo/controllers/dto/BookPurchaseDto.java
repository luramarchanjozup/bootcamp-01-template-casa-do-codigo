package com.casadocodigo.casaDoCodigo.controllers.dto;

import com.casadocodigo.casaDoCodigo.model.Book;

public class BookPurchaseDto {
    private Long id;
    private String title;
    private Float price;

    public BookPurchaseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.price = book.getPrice();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
