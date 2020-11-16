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
import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    /* pontos de dificuldade de entendimento = 3 */


    /* @complexidade (1) - acoplamento contextual */
    private final CategoryRepository categoryRepository;


    private final Logger logger = LoggerFactory.getLogger(Category.class);


    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody @Valid CategoryForm categoryForm,
                                            UriComponentsBuilder uriComponentsBuilder){

        /* @complexidade (2) - método em classe específica do projeto */
        var category = categoryForm.toEntity();
        categoryRepository.save(category);

        logger.info("[NOVA CATEGORIA] Nova categoria de nome {} criada em {} com sucesso",
                category.getName(), OffsetDateTime.now());

        return ResponseEntity
                .created(uriComponentsBuilder.path("/api/categories").buildAndExpand().toUri())
                .body(category);

    }
}
