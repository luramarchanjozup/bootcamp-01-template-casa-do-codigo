package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entity.Autor;
import br.com.zup.treinocasadocodigo.entity.NovoAutorRequest;
import br.com.zup.treinocasadocodigo.repository.AutorRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;

@RestController
public class AutoresController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value="/autores")
    @Transactional
    public String cadastroAutor(@RequestBody @Valid NovoAutorRequest novoAutor) {
        Autor autor = novoAutor.toModel();
        manager.persist(autor);
        return autor.toString();
    }
}
