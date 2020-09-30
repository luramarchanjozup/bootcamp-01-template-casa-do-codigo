package br.com.casadocodigo.dtos;

import br.com.casadocodigo.models.Category;

public class CategoryDto {

    private String name;

    public CategoryDto(Category category){
        this.name = category.getName();
    }

    public String getName() {
        return name;
    }
}
