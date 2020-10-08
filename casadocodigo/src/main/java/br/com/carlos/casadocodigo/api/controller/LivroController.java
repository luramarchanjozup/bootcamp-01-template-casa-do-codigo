package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.RequestLivroDto;
import br.com.carlos.casadocodigo.api.dto.ResponseLivroDto;
import br.com.carlos.casadocodigo.domain.entity.Livro;
import br.com.carlos.casadocodigo.domain.repository.LivroRepository;
import br.com.carlos.casadocodigo.domain.service.CadastrarLivrosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CadastrarLivrosService livrosService;
    @Autowired
    private LivroRepository repository;
    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseLivroDto adicionar(@Valid @RequestBody RequestLivroDto request){
        Livro livro = mapper.map(request.toEntity(manager), Livro.class);
        return mapper.map(livrosService.criar(livro), ResponseLivroDto.class);
    }

    @GetMapping
    private ResponseEntity<?> Listar(){
        return ResponseEntity.ok(repository.findAll().stream()
                .map(ResponseLivroDto::converter).collect(Collectors.toList()));
    }

}
