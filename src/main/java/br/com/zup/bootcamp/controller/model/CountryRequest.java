package br.com.zup.bootcamp.controller.model;

import br.com.zup.bootcamp.controller.validator.annotation.Unique;
import br.com.zup.bootcamp.domain.model.Country;

import javax.validation.constraints.NotBlank;

// Intrinsic charge = 2
public class CountryRequest {
    @NotBlank(message = "Name is mandatory")
    @Unique(message = "Country already registered", fieldName = "name", domainClass = Country.class)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country convert(){
        return new Country(this.name);
    }
}
