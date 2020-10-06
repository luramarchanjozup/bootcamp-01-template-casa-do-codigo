package com.github.marcoscoutozup.casadocodigo.autor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional                                      //1
    public String cadastrarAutor(@RequestBody @Valid AutorDTO dto){
        Autor autor = dto.toModel();
        entityManager.persist(autor);
        return autor.toString();
    }

}
