package com.casadocodigo.casaDoCodigo.controllers.form;

import javax.validation.constraints.NotBlank;

public class CategoryForm {
    
    @NotBlank
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
