package br.com.casadocodigo.dtos;

import br.com.casadocodigo.models.*;

public class ShopDto {

    private Double total;

    private Double totalWithDiscount;

    private String email;

    private String name;

    private String lastName;

    private String identification;

    private String address;

    private String complement;

    private String city;

    private Country country;

    private State state;

    private String phone;

    private String cep;


    public ShopDto(UserData userData, ShoppingCartPrice shoppingCartPrice) {

        this.email = userData.getEmail();
        this.name = userData.getName();
        this.lastName = userData.getLastName();
        this.identification = userData.getIdentification();
        this.address = userData.getAddress();
        this.complement = userData.getComplement();
        this.city = userData.getCity();
        this.country = userData.getCountry();
        this.state = userData.getState();
        this.phone = userData.getPhone();
        this.cep = userData.getCep();
        this.total = shoppingCartPrice.getTotal();
        this.totalWithDiscount = shoppingCartPrice.getTotalWithDiscount();

    }

    public ShopDto(ShoppingCartPrice shoppingCartPrice){

        this.total = shoppingCartPrice.getTotal();
        this.totalWithDiscount = shoppingCartPrice.getTotalWithDiscount();

    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotalWithDiscount() {
        return totalWithDiscount;
    }

    public void setTotalWithDiscount(Double totalWithDiscount) {
        this.totalWithDiscount = totalWithDiscount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
