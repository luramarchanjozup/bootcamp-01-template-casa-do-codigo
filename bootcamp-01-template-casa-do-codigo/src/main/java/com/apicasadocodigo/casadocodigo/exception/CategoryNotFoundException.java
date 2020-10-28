package com.apicasadocodigo.casadocodigo.exception;


import com.apicasadocodigo.casadocodigo.model.Category;

public class CategoryNotFoundException extends EntityNotFoundException {

    public CategoryNotFoundException(Long id){
        super(Category.class, id.toString());
    }
}
