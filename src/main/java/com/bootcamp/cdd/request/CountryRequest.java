package com.bootcamp.cdd.request;

import com.bootcamp.cdd.models.Country;
import com.bootcamp.cdd.shared.UniqueValue;

import javax.validation.constraints.NotEmpty;

public class CountryRequest {
    @UniqueValue(domainClass = Country.class, fieldName = "name", message = "esse pais já foi cadastrado")
    @NotEmpty(message = "o nome do pais deve ser preenchido")
    private String name;

    public CountryRequest(String name) {
        this.name = name;
    }
    public CountryRequest () {}

    public String getName() {
        return name;
    }

    public Country toModel () {
        return new Country(name);
    }
}
