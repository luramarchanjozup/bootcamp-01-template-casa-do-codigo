package com.bootcamp.cdd.controllers;

import com.bootcamp.cdd.models.Category;
import com.bootcamp.cdd.request.CategoryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public Category addCategory (@RequestBody @Valid CategoryRequest request) {
        Category category = request.toModel();
        entityManager.persist(category);
        return category;
    }
}
