package com.bootcamp.cdd.request;

import com.bootcamp.cdd.models.Category;
import com.bootcamp.cdd.shared.UniqueValue;

import javax.validation.constraints.NotEmpty;

public class CategoryRequest {
    @UniqueValue(domainClass = Category.class, fieldName = "name") @NotEmpty(message = "categoria precisa ser preenchida") private String name;

    public CategoryRequest(@NotEmpty(message = "categoria precisa ser preenchida") String name) {
        this.name = name;
    }

    public CategoryRequest () {}

    public String getName() {
        return name;
    }

    public Category toModel() {
        return new Category(this.name);
    }
}
