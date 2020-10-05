package com.bootcamp.cdd.controllers;

import com.bootcamp.cdd.models.Category;
import com.bootcamp.cdd.request.CategoryRequest;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @PersistenceContext
    private EntityManager entityManager;



    @PostMapping
    @Transactional
    public Category addCategory (@RequestBody CategoryRequest request) {
        Category category = request.toModel();
        entityManager.persist(category);
        return category;
    }
}
