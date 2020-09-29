package com.casadocodigo.casaDoCodigo.controllers;

import java.net.URI;

import javax.validation.Valid;

import com.casadocodigo.casaDoCodigo.controllers.form.BookForm;
import com.casadocodigo.casaDoCodigo.model.Book;
import com.casadocodigo.casaDoCodigo.services.BookServices;
import com.casadocodigo.casaDoCodigo.services.CheckDuplicatedBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/book")
public class BookController {
    
    @Autowired
    private BookServices bookServices;
    @Autowired
    private CheckDuplicatedBook checkDuplicatedBook;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(checkDuplicatedBook);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody @Valid BookForm form, UriComponentsBuilder uriBuilder) {
        Book book = bookServices.createBook(form);
        URI uri = uriBuilder.path("book/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body(book);
    }
}
