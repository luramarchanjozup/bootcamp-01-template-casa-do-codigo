package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.RequestEstadoDto;
import br.com.carlos.casadocodigo.api.dto.RequestPaisDto;
import br.com.carlos.casadocodigo.api.dto.ResponseEstadoDto;
import br.com.carlos.casadocodigo.api.dto.ResponsePaisDto;
import br.com.carlos.casadocodigo.domain.entity.Estado;
import br.com.carlos.casadocodigo.domain.entity.Pais;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CadastrarRegiaoController {

    @Autowired
    private ModelMapper mapper;
    @PersistenceContext
    private EntityManager manager;

    @PostMapping("pais")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public ResponsePaisDto adicionarPais(@Valid @RequestBody RequestPaisDto request) {
        var pais = mapper.map(request, Pais.class);
        manager.persist(pais);
        return mapper.map(pais, ResponsePaisDto.class);
    }

    @PostMapping("estado")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public ResponseEstadoDto adicionarEstado(@Valid @RequestBody RequestEstadoDto request){
        var estado =mapper.map(request.toEntity(manager), Estado.class);
        manager.persist(estado);
        return mapper.map(estado, ResponseEstadoDto.class);
    }
}
