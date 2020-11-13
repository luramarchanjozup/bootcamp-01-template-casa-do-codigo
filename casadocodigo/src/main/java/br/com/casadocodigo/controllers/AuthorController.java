package br.com.casadocodigo.controllers;

import br.com.casadocodigo.forms.AuthorForm;
import br.com.casadocodigo.models.Author;
import br.com.casadocodigo.repositories.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    /* pontos de dificuldade de entendimento =   */

    /* @complexidade (1) - acoplamento contextual */
    private final AuthorRepository authorRepository;

    private final Logger logger = LoggerFactory.getLogger(Author.class);


    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping              /* @complexidade (1) - classe específica do projeto */
    public ResponseEntity<?> createAuthor(@RequestBody @Valid AuthorForm authorForm
                ,UriComponentsBuilder uriComponentsBuilder){

            /* @complexidade (2) - método em classe específica do projeto */
            var author = authorForm.toEntity();
            authorRepository.save(author);

            logger.info("[NOVO AUTOR] Autor {} criado com sucesso", author.getName());

        return ResponseEntity
                .created(uriComponentsBuilder.path("/api/authors").buildAndExpand().toUri())
                .body(author);

    }
}
