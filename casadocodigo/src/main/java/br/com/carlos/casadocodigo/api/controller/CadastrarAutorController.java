package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.request.RequestAutorDto;
import br.com.carlos.casadocodigo.api.dto.response.ResponseAutorDto;
import br.com.carlos.casadocodigo.domain.entity.Autor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class CadastrarAutorController {
    @Autowired
    private ModelMapper mapper;

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
            //1                                             //1
    public ResponseAutorDto adicionar(@Valid @RequestBody RequestAutorDto request) {
                                              //1
        var autor = mapper.map(request, Autor.class);
        manager.persist(autor);
        return  mapper.map(autor, ResponseAutorDto.class);
    }
}
