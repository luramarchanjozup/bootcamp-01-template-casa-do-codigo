package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.domain.Book;
import br.com.zup.casadocodigo.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value="books")
public class BookController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional

    public ResponseEntity<?> create(@RequestBody @Valid BookDTO bookDto) {
        Book createdBook = bookDto.toModel(entityManager);
        entityManager.persist(createdBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }


}
