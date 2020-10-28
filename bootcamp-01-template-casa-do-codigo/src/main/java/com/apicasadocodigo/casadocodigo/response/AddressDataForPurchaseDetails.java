package com.apicasadocodigo.casadocodigo.response;

import com.apicasadocodigo.casadocodigo.model.Address;

public class AddressDataForPurchaseDetails {

    private String publicPlace;

    private Integer numberHouse;

    private String cityName;

    private String stateName;

    private String countryName;

    public AddressDataForPurchaseDetails(Address address){
        this.publicPlace = address.getPublicPlace();
        this.numberHouse = address.getNumberHouse();
        this.cityName = address.getCity().getName();
        this.stateName = address.getCity().getStateyName();
        this.countryName = address.getCity().getCountryName();
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public Integer getNumberHouse() {
        return numberHouse;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public String getCountryName() {
        return countryName;
    }
}
