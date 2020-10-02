package com.casadocodigo.casaDoCodigo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.casadocodigo.casaDoCodigo.controllers.form.PurchaseForm;

@Entity
public class Purchases {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull @Email
    private String email;
    @NotNull
    private String document;
    @NotNull
    private String address;
    @NotNull
    private String complement;
    @NotNull
    private String city;
    @NotNull @ManyToOne
    private State state;
    @NotNull @ManyToOne
    private Country country;
    @NotNull
    private String phone;
    @NotNull
    private String cep;
    @NotNull @ManyToOne(cascade = {CascadeType.ALL})
    private Cart cart;

    @Deprecated
    public Purchases(){}

    public Purchases(String name, String lastName, String email, String document, String address, 
                    String complement, String city, State state, Country country, String phone, String cep, Cart cart) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.country = country;
        this.phone = phone;
        this.cep = cep;
        this.cart = cart;
    }

    public Purchases(PurchaseForm form, State state, Country country, Cart cart) {
        this.name = form.getName();
        this.lastName = form.getLastName();
        this.email = form.getEmail();
        this.document = form.getDocument();
        this.address = form.getAddress();
        this.complement = form.getComplement();
        this.city = form.getCity();
        this.state = state;
        this.country = country;
        this.phone = form.getPhone();
        this.cep = form.getCep();
        this.cart = cart;

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

    public String getEmail() {
        return this.email;
    }

    public String getDocument() {
        return this.document;
    }

    public String getAddress() {
        return this.address;
    }

    public String getComplement() {
        return this.complement;
    }

    public String getCity() {
        return this.city;
    }

    public State getState() {
        return this.state;
    }

    public Country getCountry() {
        return this.country;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getCep() {
        return this.cep;
    }

    public Cart getCart() {
        return this.cart;
    }

}
