package br.com.zup.bootcamp.controller.model;

import br.com.zup.bootcamp.database.model.Category;

import javax.validation.constraints.NotBlank;

public class CategoryRequest {
    @NotBlank(message = "Name is mandatory")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category convert(){
        return new Category(this.name);
    }
}
