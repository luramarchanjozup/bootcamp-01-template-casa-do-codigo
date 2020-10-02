package com.casadocodigo.casaDoCodigo.controllers;

import javax.validation.Valid;

import com.casadocodigo.casaDoCodigo.controllers.form.CategoryForm;
import com.casadocodigo.casaDoCodigo.model.Category;
import com.casadocodigo.casaDoCodigo.services.CategoryServices;
import com.casadocodigo.casaDoCodigo.services.validators.CheckDuplicatedCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
    @Autowired
    private CheckDuplicatedCategory checkDuplicatedCategory;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(checkDuplicatedCategory);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody @Valid CategoryForm form, UriComponentsBuilder uriBuilder) {
        return ResponseEntity.ok().body(categoryServices.createCategory(form.getName()));
    }
}
