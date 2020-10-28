package com.apicasadocodigo.casadocodigo.response;

import com.apicasadocodigo.casadocodigo.model.City;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CityResponse {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private StateResponse state;

    @NotNull
    private CountryResponse country;

    public CityResponse(City city) {
        this.name = city.getName();
        this.state = new StateResponse(city.getState());
        this.country = new CountryResponse(city.getCountry());
    }

    public String getName() {
        return name;
    }

    public StateResponse getState() {
        return state;
    }


}
