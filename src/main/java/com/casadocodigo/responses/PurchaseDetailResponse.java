package com.casadocodigo.responses;

import com.casadocodigo.entity.Purchase;

public class PurchaseDetailResponse {

    private String email;
    private String name;
    private String lastName;
    private String document;
    private String adress;
    private String complement;
    private Long phone;
    private Long cep;
    private CountryDetailResponse country;
    private StateDetailResponse state;
    private CartDetailResponse cart;

    public PurchaseDetailResponse(Purchase purchase) {
        email = purchase.getEmail();
        name = purchase.getName();
        lastName = purchase.getLastName();
        document = purchase.getDocument();
        adress = purchase.getAdress();
        complement = purchase.getComplement();
        phone = purchase.getPhone();
        cep = purchase.getCep();
        country = new CountryDetailResponse(purchase.getCountry());
        state = new StateDetailResponse(purchase.getState());
        cart = new CartDetailResponse(purchase.getCart());
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAdress() {
        return adress;
    }

    public String getComplement() {
        return complement;
    }

    public Long getPhone() {
        return phone;
    }

    public Long getCep() {
        return cep;
    }

    public CountryDetailResponse getCountry() {
        return country;
    }

    public StateDetailResponse getState() {
        return state;
    }

    public CartDetailResponse getCart() {
        return cart;
    }
}
