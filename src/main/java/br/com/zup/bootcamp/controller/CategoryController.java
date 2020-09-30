package br.com.zup.bootcamp.controller;

import br.com.zup.bootcamp.controller.model.CategoryRequest;
import br.com.zup.bootcamp.controller.model.GenericResponse;
import br.com.zup.bootcamp.database.model.Category;
import br.com.zup.bootcamp.database.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Intrinsic charge = 4
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository repository;

    @PostMapping
    public ResponseEntity<GenericResponse> register(@RequestBody @Validated CategoryRequest request){
        GenericResponse response;
        if(repository.findByName(request.getName()).isPresent()){
            response = new GenericResponse("Category name already registered");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }

        Category newCategory = request.convert();
        repository.save(newCategory);

        response = new GenericResponse("Category was registered");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
