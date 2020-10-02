package br.com.zup.bootcamp.controller.model;

import br.com.zup.bootcamp.controller.validator.annotation.Exist;
import br.com.zup.bootcamp.controller.validator.annotation.Unique;
import br.com.zup.bootcamp.domain.model.Country;
import br.com.zup.bootcamp.domain.model.State;

import javax.validation.constraints.NotBlank;

// Intrinsic charge = 4
public class StateRequest {
    @NotBlank(message = "Country is mandatory")
    @Exist(message = "Country not found", fieldName = "id", domainClass = Country.class)
    private String country;

    @NotBlank(message = "Name is mandatory")
    @Unique(message = "State already registered", fieldName = "name", domainClass = State.class)
    private String name;

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State convert(){
        Country country = new Country();
        country.setId(this.country);
        return new State(country, this.name);
    }
}
