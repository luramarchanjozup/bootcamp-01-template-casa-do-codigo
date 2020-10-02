package com.casadocodigo.casaDoCodigo.services;

import com.casadocodigo.casaDoCodigo.model.Category;
import com.casadocodigo.casaDoCodigo.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServices {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(String name) {
        Category category = new Category(name);
        categoryRepository.save(category);

        return category;
    }
}
