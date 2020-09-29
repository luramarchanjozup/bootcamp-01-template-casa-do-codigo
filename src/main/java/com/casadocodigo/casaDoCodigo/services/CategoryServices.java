package com.casadocodigo.casaDoCodigo.services;

import java.util.List;
import java.util.Optional;

import com.casadocodigo.casaDoCodigo.model.Category;
import com.casadocodigo.casaDoCodigo.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServices {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> detailedIndex(Long id) {
        Optional<Category> categoryObj = categoryRepository.findById(id);
        return categoryObj;
    }

    public List<Category> index() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    public Category createCategory(String name) {
        Category category = new Category(name);
        categoryRepository.save(category);

        return category;
    }
}
