package br.com.zup.bootcamp.controller.model;

import br.com.zup.bootcamp.controller.validator.annotation.Exist;
import br.com.zup.bootcamp.domain.model.Buyer;
import br.com.zup.bootcamp.domain.model.Country;
import br.com.zup.bootcamp.domain.model.State;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// Intrinsic charge = 6
public class BuyerRequest {
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email invalid")
    private String email;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Last name is mandatory")
    private String lastname;

    @NotBlank(message = "Document is mandatory")
    private String document;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotBlank(message = "Complement is mandatory")
    private String complement;

    @NotBlank(message = "City is mandatory")
    private String city;

    @Exist(message = "State not found", fieldName = "id", domainClass = State.class)
    private String state;

    @NotBlank(message = "Country is mandatory")
    @Exist(message = "Country not fount", fieldName = "id", domainClass = Country.class)
    private String country;

    @NotBlank(message = "Phone number is mandatory")
    private String phone;

    @NotBlank(message = "CEP is mandatory")
    private String cep;

    @NotNull(message = "Cart is mandatory")
    @Valid
    private CartRequest cart;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }

    public CartRequest getCart() {
        return cart;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCart(CartRequest cart) {
        this.cart = cart;
    }

    public Buyer convert(){
        State state = null;
        if(this.state != null && !this.state.isEmpty() && !this.state.isBlank()){
            state = new State();
            state.setId(this.state);
        }

        Country country = new Country();
        country.setId(this.country);
        return new Buyer(this.email, this.name, this.lastname, this.document, this.address, this.complement, this.city,
                state, country, this.phone, this.cep);
    }
}
