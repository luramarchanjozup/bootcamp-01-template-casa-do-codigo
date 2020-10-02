package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.Autor;
import br.com.zup.treinocasadocodigo.entities.NovoAutorRequest;
import br.com.zup.treinocasadocodigo.repository.AutorRepository;
import br.com.zup.treinocasadocodigo.validators.AutorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

/**
 * Contagem de carga intrínseca da classe: 3
 */

@RestController
public class AutoresController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    //1
    private AutorValidator autorValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(autorValidator);
    }

    @PostMapping(value="/autores")
    @Transactional
    //1
    public String cadastroAutor(@RequestBody @Valid NovoAutorRequest novoAutor) {

        //1
        Autor autor = novoAutor.toModel();
        manager.persist(autor);
        return autor.toString();
    }
}
