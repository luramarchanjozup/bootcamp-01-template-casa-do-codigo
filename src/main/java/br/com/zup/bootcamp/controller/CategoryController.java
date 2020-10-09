package br.com.zup.bootcamp.controller;

import br.com.zup.bootcamp.controller.model.CategoryRequest;
import br.com.zup.bootcamp.controller.model.GenericResponse;
import br.com.zup.bootcamp.domain.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// Intrinsic charge = 3
@RestController
@RequestMapping("/category")
public class CategoryController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<GenericResponse> register(@RequestBody @Validated CategoryRequest request){
        Category newCategory = request.convert();
        manager.persist(newCategory);

        GenericResponse response = new GenericResponse("Category was registered");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
