package com.apicasadocodigo.casadocodigo.response;

import com.apicasadocodigo.casadocodigo.model.Category;

public class CategoryResponse {

    private String name;

    public CategoryResponse(Category category){
        this.name = category.getName();
    }

    public String getName(){
        return this.name;
    }
}
