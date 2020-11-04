package bootcamp.challenges.casadocodigo.controllers;

import bootcamp.challenges.casadocodigo.dtos.CategoryDto;
import bootcamp.challenges.casadocodigo.entities.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

// Total Intrinsic Load Points: 2
@RequestMapping("/categories")
@RestController
public class CategoryController {

    @PersistenceContext
    EntityManager entityManager;
    @PostMapping
    @Transactional
    public ResponseEntity<Void> categoryRegister(@RequestBody @Valid CategoryDto categoryDto){ // 1 - CategoryDto
        Category category = categoryDto.toModel(); // 1 - Category
        entityManager.persist(category);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(category.getId()).toUri()).build();
    }
}
