package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.RequestAutorDto;
import br.com.carlos.casadocodigo.api.dto.ResponseAutorDto;
import br.com.carlos.casadocodigo.domain.entity.Autor;
import br.com.carlos.casadocodigo.domain.repository.AutorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class CadastrarAutorController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AutorRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseAutorDto adicionar(@Valid @RequestBody RequestAutorDto request) {
        var autor = mapper.map(request, Autor.class);
        return  mapper.map(repository.save(autor), ResponseAutorDto.class);
    }
}
