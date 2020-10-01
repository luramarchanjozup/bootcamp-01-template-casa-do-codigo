package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entity.Autor;
import br.com.zup.treinocasadocodigo.repository.AutorRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorController {

    private final AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/v1/autor")
    public Autor cadastroAutor(@RequestBody Autor novoAutor) {
        return repository.save(novoAutor);
    }
}
