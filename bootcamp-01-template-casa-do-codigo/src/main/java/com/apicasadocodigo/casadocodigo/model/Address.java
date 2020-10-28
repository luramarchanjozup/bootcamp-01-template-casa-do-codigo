package com.apicasadocodigo.casadocodigo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {

    @NotEmpty
    @NotNull
    private String publicPlace;

    @NotEmpty
    @NotNull
    private String complement;

    @NotEmpty
    @NotNull
    @Column(name = "number_house")
    private Integer numberHouse;

    @NotEmpty
    @NotNull
    @ManyToOne
    private City city;

    @NotEmpty
    @NotNull
    private String state;

    @NotEmpty
    @NotNull
    private String country;

    @NotEmpty
    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;

    @Deprecated
    public Address(){

    }

    public Address(@NotEmpty @NotNull String publicPlace, @NotEmpty @NotNull String complement,
                   @NotEmpty @NotNull Integer numberHouse, @NotEmpty @NotNull City city,
                   @NotEmpty @NotNull String phoneNumber) {

        this.publicPlace = publicPlace;
        this.complement = complement;
        this.numberHouse = numberHouse;
        this.city = city;
        this.phoneNumber = phoneNumber;

    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public String getComplement() {
        return complement;
    }

    public Integer getNumberHouse() {
        return numberHouse;
    }

    public City getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setCityAndStateAndCountry(City city){
        this.setCity(city);
        this.setState(city.getStateyName());
        this.setCountry(city.getCountryName());
    }

    private void setState(String state) {
        this.state = state;
    }

    private void setCountry(String country) {
        this.country = country;
    }

    private void setCity(City city) {
        this.city = city;
    }

    @JsonIgnore
    public Long getCityId(){
        return city.getId();
    }
}
