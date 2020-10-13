package com.casadocodigo.responses;

import com.casadocodigo.entity.Author;
import com.casadocodigo.entity.Categories;

public class CategoryBookResponse {

    private Long id;
    private String name;

    public CategoryBookResponse(Categories categories) {
        this.id = categories.getId();
        this.name = categories.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
