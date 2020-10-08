package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.controller;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Livro;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.NovoLivroRequest;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping(value = "/novoLivro")
public class NovoLivroController {

    @Autowired
    EntityManager entityManager;

    @Autowired
    LivroService livroService;

    //Cadastra um novo Livro
    @PostMapping
    @Transactional
    public ResponseEntity<Livro> cadastrarLivro(@Validated @RequestBody NovoLivroRequest novoLivroRequest){

        livroService.validaNovoLivro(novoLivroRequest);

        Livro novoLivro = novoLivroRequest.toModel();
        entityManager.persist(novoLivro);
        return ResponseEntity.status(HttpStatus.OK).body(novoLivro);
    }

}
