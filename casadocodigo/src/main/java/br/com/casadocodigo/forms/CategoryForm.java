package br.com.casadocodigo.forms;

import br.com.casadocodigo.models.Category;
import br.com.casadocodigo.validation.Unique;

import javax.validation.constraints.NotBlank;

public class CategoryForm {

    @NotBlank
    @Unique(fieldName = "name", domainClass = Category.class)
    private String name;

    @Deprecated
    public CategoryForm(){ };

    public CategoryForm(String name){
        this.name = name;
    }

    public Category toEntity(){
        return new Category(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
