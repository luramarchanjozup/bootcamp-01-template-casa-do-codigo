package com.casadocodigo.casaDoCodigo.controllers.dto;

import java.util.List;

import com.casadocodigo.casaDoCodigo.model.Purchases;

public class PurchaseDto {
    private Long id;
    private String name;
    private String lastName;
    private String document;
    private String address;
    private List<BookPurchaseDto> boughtBooks;
    private Float finalPrice;

    public PurchaseDto(Purchases purchase, List<BookPurchaseDto> books, float finalPrice) {
        this.id = purchase.getId();
        this.name = purchase.getName();
        this.lastName = purchase.getLastName();
        this.document = purchase.getDocument();
        this.address = purchase.getAddress();
        this.boughtBooks = books;
        this.finalPrice = finalPrice;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getDocument() {
        return this.document;
    }

    public String getAddress() {
        return this.address;
    }

    public List<BookPurchaseDto> getBoughtBooks() {
        return this.boughtBooks;
    }

    public Float getFinalPrice() {
        return this.finalPrice;
    }

}
