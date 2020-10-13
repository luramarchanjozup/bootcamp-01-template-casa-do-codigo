package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Categoria;
import br.com.treino.casadocodigo.request.NovaCategoriaRequest;
import org.apache.coyote.Response;
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
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity novaCategoria(@RequestBody @Valid NovaCategoriaRequest request){ //1
        Categoria novaCategoria = new Categoria(request.getNome()); //2
        entityManager.persist(novaCategoria);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
