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

    public Double getTotalWithDiscount() {
        return totalWithDiscount;
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

    public String getIdentification() {
        return identification;
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

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }
}
