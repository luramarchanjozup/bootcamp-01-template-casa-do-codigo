package com.apicasadocodigo.casadocodigo.controller;

import com.apicasadocodigo.casadocodigo.model.Book;
import com.apicasadocodigo.casadocodigo.request.BookRequest;
import com.apicasadocodigo.casadocodigo.response.BookResponse;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import com.apicasadocodigo.casadocodigo.validator.UniqueBookIsbnValidator;
import com.apicasadocodigo.casadocodigo.validator.UniqueBookTitleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired   //1
    private GenericDAO genericDAO; ;

    @Autowired   //2
    private UniqueBookIsbnValidator uniqueBookIsbnValidator;

    @Autowired   //3
    private UniqueBookTitleValidator uniqueBookTitleValidator;


    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(uniqueBookIsbnValidator);
        binder.addValidators(uniqueBookTitleValidator);
    }

    @PostMapping                                                        //4
    public ResponseEntity<?> saveBookFromRequest(@RequestBody @Valid BookRequest bookRequest, UriComponentsBuilder builder){
        Long id = genericDAO.saveEntity(bookRequest.toModel(genericDAO)).getId();
        URI uri = builder.path("books/{id}").build(id);
        return ResponseEntity.ok(uri);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookFromId(@PathVariable Long id){
        return ResponseEntity.ok()
                .body(genericDAO.findEntityDyId(Book.class, id));
    }

    @GetMapping
    public List<?> findAll(){
        return genericDAO.findAllFrom(Book.class)
                .stream()  //5
                    .map(b -> BookResponse.fromModel(b)) //6
                .collect(Collectors.toList());
    }
    //Pontos CDD: 6
}
