package br.com.zup.bootcamp.controller.model;

import br.com.zup.bootcamp.domain.model.Buyer;

// Intrinsic charge = 1
public class BuyerResponse {
    private String id;
    private String email;
    private String name;
    private String lastname;
    private String address;
    private String complement;
    private String city;
    private String state;
    private String country;
    private String phone;
    private String cep;
    private PurchaseResponse purchase;

    public BuyerResponse(){}

    public BuyerResponse(Buyer buyer){
        this.id = buyer.getId();
        this.email = buyer.getEmail();
        this.name = buyer.getName();
        this.lastname = buyer.getLastname();
        this.address = buyer.getAddress();
        this.complement = buyer.getComplement();
        this.city = buyer.getCity();
        this.state = buyer.getState().getName();
        this.country = buyer.getCountry().getName();
        this.phone = buyer.getPhone();
        this.cep = buyer.getCep();
        this.purchase = new PurchaseResponse(buyer.getPurchase());
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
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

    public PurchaseResponse getPurchase() {
        return purchase;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setPurchase(PurchaseResponse purchase) {
        this.purchase = purchase;
    }
}
