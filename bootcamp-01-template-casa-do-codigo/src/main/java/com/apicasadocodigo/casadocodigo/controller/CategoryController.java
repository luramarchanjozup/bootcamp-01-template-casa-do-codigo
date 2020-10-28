package com.apicasadocodigo.casadocodigo.controller;

import com.apicasadocodigo.casadocodigo.model.Category;
import com.apicasadocodigo.casadocodigo.request.CategoryRequest;
import com.apicasadocodigo.casadocodigo.response.CategoryResponse;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import com.apicasadocodigo.casadocodigo.validator.UniqueCategoryNameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/categorys")
public class CategoryController {

    @Autowired //1
    private GenericDAO genericDAO;

    @Autowired //2
    private UniqueCategoryNameValidator uniqueCategoryNameValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(uniqueCategoryNameValidator);
    }

    @PostMapping                                                  //3
    public ResponseEntity<?> saveCategory(@RequestBody @Valid CategoryRequest request, UriComponentsBuilder builder){

        Long categoryId = genericDAO.saveEntity(request.toModel()).getId();
        URI addressConsult = builder.path("/categorys/{id}").build(categoryId);

        return ResponseEntity.ok(addressConsult);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Long id){

                //4
        CategoryResponse response = new CategoryResponse(genericDAO.findEntityDyId(Category.class, id));

        return ResponseEntity.ok(response);
    }
    //Pontos CDD: 4
}
