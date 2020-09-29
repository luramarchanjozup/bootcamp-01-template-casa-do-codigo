package com.casadocodigo.casaDoCodigo.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.casadocodigo.casaDoCodigo.controllers.form.CategoryForm;
import com.casadocodigo.casaDoCodigo.model.Category;
import com.casadocodigo.casaDoCodigo.services.CategoryServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    private CategoryServices categoryServices;

    @GetMapping
    public ResponseEntity<List<Category>> index() {
        List<Category> categories = categoryServices.index();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> detailedIndex(@PathVariable Long id) {
        Optional<Category> categoryObj = categoryServices.detailedIndex(id);
        return categoryObj.isPresent() ? ResponseEntity.ok().body(categoryObj.get()) : ResponseEntity.notFound().build();
    }  

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody @Valid CategoryForm form, UriComponentsBuilder uriBuilder) {
        Category category = categoryServices.createCategory(form.getName());
        URI uri = uriBuilder.path("categories/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(category);
    }
}
