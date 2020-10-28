package com.apicasadocodigo.casadocodigo.response;

import com.apicasadocodigo.casadocodigo.model.State;

public class StateResponse {

    private String name;

    private CountryResponse country;

    public StateResponse(State state){
        this.name = state.getName();
        this.country = new CountryResponse(state.getCountry());
    }

    public String getName(){
        return this.name;
    }

    public CountryResponse getCountry() {
        return country;
    }

    public void setResponse(CountryResponse response) {
        this.country = response;
    }
}
