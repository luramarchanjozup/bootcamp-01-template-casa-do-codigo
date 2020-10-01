package com.bootcamp.cdd.request;

import com.bootcamp.cdd.models.Category;

public class CategoryRequest {
    private String name;

    public CategoryRequest (String name) {
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
