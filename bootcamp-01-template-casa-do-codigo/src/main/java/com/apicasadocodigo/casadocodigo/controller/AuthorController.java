package com.apicasadocodigo.casadocodigo.controller;

import com.apicasadocodigo.casadocodigo.model.Author;
import com.apicasadocodigo.casadocodigo.request.AuthorRequest;
import com.apicasadocodigo.casadocodigo.response.AuthorResponse;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import com.apicasadocodigo.casadocodigo.validator.UniqueAuthorEmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired   //1
    private GenericDAO genericDAO;

    @Autowired //2
    private UniqueAuthorEmailValidator uniqueAuthorEmailValidator;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(uniqueAuthorEmailValidator);
    }

    @PostMapping//3
    public ResponseEntity<?> save(@RequestBody @Valid AuthorRequest requestBody, UriComponentsBuilder builder) {

        Long idAddress = genericDAO.saveEntity(requestBody.toModel()).getId();
        URI addressConsult = builder.path("/authors/{id}").build(idAddress);

        return ResponseEntity.created(addressConsult).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable Long id){
            //4
        AuthorResponse response = new AuthorResponse(genericDAO.findEntityDyId(Author.class, id));

        return ResponseEntity.ok(response);
    }
    //Pontos CDD: 4
}
