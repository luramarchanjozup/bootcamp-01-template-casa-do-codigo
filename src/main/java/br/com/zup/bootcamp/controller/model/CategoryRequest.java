package br.com.zup.bootcamp.controller.model;

import br.com.zup.bootcamp.controller.validator.annotation.Unique;
import br.com.zup.bootcamp.domain.model.Category;

import javax.validation.constraints.NotBlank;

// Intrinsic charge = 1
public class CategoryRequest {
    @NotBlank(message = "Name is mandatory")
    @Unique(message = "Category already registered", fieldName = "name", domainClass = Category.class)
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
