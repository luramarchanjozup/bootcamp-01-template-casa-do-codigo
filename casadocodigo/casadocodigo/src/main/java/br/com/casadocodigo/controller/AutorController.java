package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.Autor;
import br.com.casadocodigo.model.NovoAutorRequest;
import br.com.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;
//    @Autowired
//    private AutorRepository autorRepository;

    @PostMapping("/autor")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public String criaAutor(@Valid @RequestBody NovoAutorRequest novoAutorRequest){
        Autor novoAutor = novoAutorRequest.toAutor();
        entityManager.persist(novoAutor);
        //autorRepository.save(novoAutorRequest.toAutor());
        return novoAutor.toString();
        //entityManager.persist(NovoAutorRequest);
    }
}
