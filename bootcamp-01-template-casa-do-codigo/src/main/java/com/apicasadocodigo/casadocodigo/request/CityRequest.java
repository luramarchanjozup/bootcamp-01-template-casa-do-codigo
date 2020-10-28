package com.apicasadocodigo.casadocodigo.request;

import com.apicasadocodigo.casadocodigo.model.City;
import com.apicasadocodigo.casadocodigo.model.State;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CityRequest {


    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private State state;

    public CityRequest(@NotNull @NotEmpty String name, @NotNull State state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state){
        this.state = state;
    }

    public City toModel(){
        return new City(name, state);
    }
}
