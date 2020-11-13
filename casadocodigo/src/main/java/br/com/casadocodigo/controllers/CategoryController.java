package br.com.casadocodigo.controllers;
import br.com.casadocodigo.forms.CategoryForm;
import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.models.Category;
import br.com.casadocodigo.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    private final CategoryRepository categoryRepository;

    private final Logger logger = LoggerFactory.getLogger(Category.class);


    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody @Valid CategoryForm categoryForm,
                                            UriComponentsBuilder uriComponentsBuilder){

        var category = categoryForm.toEntity();
        categoryRepository.save(category);

        return ResponseEntity
                .created(uriComponentsBuilder.path("/api/categories").buildAndExpand().toUri())
                .body(category);

    }
}
