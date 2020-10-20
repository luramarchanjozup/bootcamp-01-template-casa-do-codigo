package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.annotations.UniqueValue;
import br.com.zup.casadocodigo.domain.Country;

import javax.validation.constraints.NotBlank;

public class CountryDTO {

    @NotBlank(message = "is required")
    @UniqueValue(domainClass = Country.class, fieldName = "name", message = "already registered")
    private String name;

    @Deprecated
    public CountryDTO(){

    }

    public CountryDTO(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
