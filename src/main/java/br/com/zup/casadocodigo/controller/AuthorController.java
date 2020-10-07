package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.domain.Author;
import br.com.zup.casadocodigo.dto.AuthorDTO;
import br.com.zup.casadocodigo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<?> save(@RequestBody @Valid AuthorDTO authorDto) {

        Author createAuthor = authorDto.transformToUser();
        entityManager.persist(createAuthor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAuthor);
    }
}
