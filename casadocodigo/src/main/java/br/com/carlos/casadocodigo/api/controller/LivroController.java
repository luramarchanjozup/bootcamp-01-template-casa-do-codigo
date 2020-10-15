package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.request.RequestLivroDto;
import br.com.carlos.casadocodigo.api.dto.response.ResponseLivroDto;
import br.com.carlos.casadocodigo.domain.entity.Livro;
import br.com.carlos.casadocodigo.domain.repository.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private ModelMapper mapper;
    @Autowired                  //1
    private LivroRepository repository;
    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
                                                        //1
    private ResponseEntity<?> adicionar(@Valid @RequestBody RequestLivroDto request, UriComponentsBuilder uriComponentsBuilder){
                                            //1             //1
        Livro livro = mapper.map(request.toEntity(manager), Livro.class);
                                            //1
        manager.persist(ResponseLivroDto.builder(livro, manager));
        return ResponseEntity.created(uriComponentsBuilder.path("/livros/{id}").
                buildAndExpand(livro.getId()).toUri()).build();
    }

    @GetMapping
    private ResponseEntity<?> Listar(){
        return ResponseEntity.ok(repository.findAll().stream()
                             //1
                .map(ResponseLivroDto::converter).collect(Collectors.toList()));
    }
}

