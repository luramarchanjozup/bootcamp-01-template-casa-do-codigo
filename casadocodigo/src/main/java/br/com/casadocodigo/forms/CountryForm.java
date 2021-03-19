package br.com.casadocodigo.forms;

import br.com.casadocodigo.models.Category;
import br.com.casadocodigo.models.Country;
import br.com.casadocodigo.validation.Unique;

import javax.validation.constraints.NotBlank;

public class CountryForm {

    @NotBlank
    @Unique(fieldName = "name", domainClass = Country.class)
    private String name;

    @Deprecated
    public CountryForm(){ }

    public CountryForm(String name){
        this.name = name;
    }

    public Country toEntity(){
        return new Country(name);
    }

    public void setName(String name) {
        this.name = name;
    }

}
