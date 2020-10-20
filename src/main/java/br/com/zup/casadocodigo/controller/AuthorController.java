package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.domain.Author;
import br.com.zup.casadocodigo.dto.AuthorDTO;
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
@RequestMapping(value="authors")
public class AuthorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid AuthorDTO authorDto) {

        Author createAuthor = authorDto.transformAuthor();
        entityManager.persist(createAuthor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAuthor);
    }
}
