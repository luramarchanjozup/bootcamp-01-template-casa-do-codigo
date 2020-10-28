package com.apicasadocodigo.casadocodigo.request;

import com.apicasadocodigo.casadocodigo.model.Country;
import com.apicasadocodigo.casadocodigo.model.State;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StateRequest {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Country country;

    public StateRequest(@NotNull @NotEmpty String name, @NotNull Country country){
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public Long getCountryId(){
        return this.getCountry().getId();
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State toModel(){
        return new State(name, country);
    }

}
