package com.apicasadocodigo.casadocodigo.response;

import com.apicasadocodigo.casadocodigo.model.Country;

public class CountryResponse {

    private String name;

    public CountryResponse(Country country){
        this.name = country.getName();
    }

    public String getName(){
        return this.name;
    }

}
