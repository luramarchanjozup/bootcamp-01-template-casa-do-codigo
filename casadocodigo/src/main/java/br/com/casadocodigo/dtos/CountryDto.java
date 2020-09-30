package br.com.casadocodigo.dtos;

import br.com.casadocodigo.models.Category;
import br.com.casadocodigo.models.Country;

public class CountryDto {

    private String name;

    public CountryDto(Country country){
        this.name = country.getName();
    }

    public String getName() {
        return name;
    }

}
