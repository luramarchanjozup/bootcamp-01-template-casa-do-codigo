package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.domain.Category;
import br.com.zup.casadocodigo.dto.CategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value="categories")
public class CategoryController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid CategoryDTO categoryDto) {

        Category createCategory = categoryDto.transformCategory();
        entityManager.persist(createCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCategory);
    }
}
