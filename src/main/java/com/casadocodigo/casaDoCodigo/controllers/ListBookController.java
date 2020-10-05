package com.casadocodigo.casaDoCodigo.controllers;

import java.util.List;

import javax.validation.Valid;

import com.casadocodigo.casaDoCodigo.controllers.dto.BookDto;
import com.casadocodigo.casaDoCodigo.controllers.dto.DetailedBookDto;
import com.casadocodigo.casaDoCodigo.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListBookController {
    
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book")
    public ResponseEntity<List<BookDto>> index() {
        return ResponseEntity.ok().body(BookDto.convert(bookRepository.findAll()));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<DetailedBookDto> detailedIndex(@PathVariable @Valid Long id) {
        return ResponseEntity.ok().body(new DetailedBookDto(bookRepository.findById(id).orElseThrow(() -> 
                                    new IllegalStateException("Book of ID " + id + " not found."))));
    }
}
