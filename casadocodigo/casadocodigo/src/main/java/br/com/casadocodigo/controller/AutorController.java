package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.Autor;
import br.com.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class AutorController {

    //+ 1
    @Autowired
    AutorRepository autorRepository;


    @PostMapping("/autor")
    // + 1
    public Autor criaAutor(@Valid @RequestBody Autor autor){

        return autorRepository.save(autor);
    }
}
