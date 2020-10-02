package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.Autor;
import br.com.zup.treinocasadocodigo.entities.NovoAutorRequest;
import br.com.zup.treinocasadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * Contagem de carga intrínseca da classe: 4
 */

@RestController
public class AutoresController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    //1
    private AutorRepository autorRepository;

    @PostMapping(value="/autores")
    @Transactional
    //1
    public String cadastroAutor(@RequestBody @Valid NovoAutorRequest novoAutor, HttpServletResponse res) {
        //1
        Autor autor = novoAutor.toModel();

        Optional<Autor> autorTeste = autorRepository.findByEmail(autor.getEmail());

        //1
        if(autorTeste.isPresent()) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "E-mail já está cadastrado";
        }

        manager.persist(autor);
        return autor.toString();
    }
}
