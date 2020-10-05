package com.casadocodigo.casaDoCodigo.controllers;

import javax.validation.Valid;

import com.casadocodigo.casaDoCodigo.controllers.dto.DetailedBookDto;
import com.casadocodigo.casaDoCodigo.controllers.form.BookForm;
import com.casadocodigo.casaDoCodigo.model.Book;
import com.casadocodigo.casaDoCodigo.repositories.AuthorRepository;
import com.casadocodigo.casaDoCodigo.repositories.BookRepository;
import com.casadocodigo.casaDoCodigo.repositories.CategoryRepository;
import com.casadocodigo.casaDoCodigo.services.validators.CheckDuplicatedBook;

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
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CheckDuplicatedBook checkDuplicatedBook;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(checkDuplicatedBook);
    }

    @PostMapping
    public ResponseEntity<DetailedBookDto> createBook(@RequestBody @Valid BookForm form, UriComponentsBuilder uriBuilder) {
        Book book = new Book(form.getTitle(), form.getResume(), form.getSummary(), form.getPrice(), form.getTotalPages(), 
                            form.getIsbn(), form.getPublicationDate(), 
                            categoryRepository.findByName(form.getCategory())
                                .orElseThrow(() -> new IllegalStateException(exceptionMsg(form.getCategory(), "Category"))), 
                            authorRepository.findByName(form.getAuthor())
                                .orElseThrow(() -> new IllegalStateException(exceptionMsg(form.getAuthor(), "Author"))));
        bookRepository.save(book);

        return ResponseEntity.ok().body(new DetailedBookDto(book));
    }

    private String exceptionMsg(String name, String element) {
        return ("There's no " + element + " " + name + " registered. Cannot register Book.\n" +
                "Make sure that the " + element + "'s name is correct");
    }
}
