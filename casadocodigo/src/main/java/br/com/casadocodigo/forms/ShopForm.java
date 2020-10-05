package br.com.casadocodigo.forms;
import br.com.casadocodigo.models.Shop;

import javax.validation.constraints.NotBlank;


public class ShopForm {

    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    private String identification;

    @NotBlank
    private String address;

    @NotBlank
    private String complement;

    @NotBlank
    private String city;

    @NotBlank
    private String phone;

    @NotBlank
    private String cep;

    @NotBlank
    private Double total;

    @Deprecated
    public ShopForm(){};

    public Shop toEntity(){
        return new Shop(email,name, lastName, identification, address, complement, city, phone, cep, total);
    }

    public ShopForm(String email, String name, String lastName, String identification, String address, String complement, String city, String country, String state, String phone, String cep, Double total) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.phone = phone;
        this.cep = cep;
        this.total = total;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
