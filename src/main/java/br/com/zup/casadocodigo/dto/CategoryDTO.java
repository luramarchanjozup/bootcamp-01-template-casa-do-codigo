package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.annotations.UniqueValue;
import br.com.zup.casadocodigo.domain.Category;

import javax.validation.constraints.NotBlank;

public class CategoryDTO {

    @NotBlank(message = "is required")
    @UniqueValue(domainClass = Category.class, fieldName = "name", message = "category already registered")
    private String name;

    @Deprecated
    public CategoryDTO() {
    }

    public CategoryDTO(@NotBlank String name) {
        this.name = name;
    }

    public Category transformCategory(){
        Category category = new Category(this.name);
        return category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
