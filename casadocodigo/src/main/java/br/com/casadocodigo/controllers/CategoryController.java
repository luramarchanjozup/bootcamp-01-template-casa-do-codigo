package br.com.casadocodigo.controllers;
import br.com.casadocodigo.dtos.CategoryDto;
import br.com.casadocodigo.forms.CategoryForm;
import br.com.casadocodigo.models.Category;
import br.com.casadocodigo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody @Valid CategoryForm categoryForm){

        Category category = categoryForm.toEntity();

        if(category != null){

            categoryRepository.save(category);
            return ResponseEntity.ok(new CategoryDto(category));

        }

        return ResponseEntity.notFound().build();

    }
}
