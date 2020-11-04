package bootcamp.challenges.casadocodigo.controllers;

import bootcamp.challenges.casadocodigo.dtos.AuthorDto;
import bootcamp.challenges.casadocodigo.entities.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

// Total Intrinsic Load Points: 2
@RestController
@RequestMapping("/authors")
public class AuthorController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> authorRegister(@RequestBody @Valid AuthorDto authorDto){ // 1 - AuthorDto
        Author author = authorDto.toModel(); // 1 - Author
        entityManager.persist(author);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(author.getId()).toUri()).build();
    }

}
