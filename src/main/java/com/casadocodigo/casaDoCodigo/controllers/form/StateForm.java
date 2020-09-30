package com.casadocodigo.casaDoCodigo.controllers.form;

import javax.validation.constraints.NotBlank;

public class StateForm {
    @NotBlank
    private String name;
    @NotBlank
    private String country;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
