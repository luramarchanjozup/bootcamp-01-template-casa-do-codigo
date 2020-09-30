package br.com.casadocodigo.forms;

import br.com.casadocodigo.models.Category;
import br.com.casadocodigo.models.Country;

public class CountryForm {

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
