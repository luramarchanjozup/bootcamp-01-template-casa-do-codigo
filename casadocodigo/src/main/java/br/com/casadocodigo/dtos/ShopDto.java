package br.com.casadocodigo.dtos;

import br.com.casadocodigo.models.*;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

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


    public ShopDto(ShopPrice shopPrice, Shop shop){

        this.total = shopPrice.getTotal();
        this.totalWithDiscount = shopPrice.getTotalWithDiscount();
        this.email = shop.getEmail();
        this.name = shop.getName();
        this.lastName = shop.getLastName();
        this.identification = shop.getIdentification();
        this.address = shop.getAddress();
        this.complement = shop.getComplement();
        this.city = shop.getCity();
        this.country = shop.getCountry();
        this.state = shop.getState();
        this.phone = shop.getPhone();
        this.cep = shop.getCep();

    }

    public ShopDto(ShopPrice shopPrice){

        this.total = shopPrice.getTotal();
        this.totalWithDiscount = shopPrice.getTotalWithDiscount();

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
