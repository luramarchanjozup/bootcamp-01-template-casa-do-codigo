package br.com.casadocodigo.controllers;

import br.com.casadocodigo.models.Category;
import br.com.casadocodigo.repositories.CategoryRepository;
import br.com.casadocodigo.services.UniqueService;
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

    @Autowired
    private UniqueService uniqueService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody @Valid Category category){

        boolean uniqueCategoryName = uniqueService.isUnique(category.getName());

        if(category != null && uniqueCategoryName){

            categoryRepository.save(category);
            return ResponseEntity.ok(category);

        }

        return ResponseEntity.notFound().build();

    }

}
