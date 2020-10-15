package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.request.RequestEstadoDto;
import br.com.carlos.casadocodigo.api.dto.request.RequestPaisDto;
import br.com.carlos.casadocodigo.api.dto.response.ResponseEstadoDto;
import br.com.carlos.casadocodigo.api.dto.response.ResponsePaisDto;
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
                //1                                             //1
    public ResponsePaisDto adicionarPais(@Valid @RequestBody RequestPaisDto request) {
                                                //1
        var pais = mapper.map(request, Pais.class);
        manager.persist(pais);
        return mapper.map(pais, ResponsePaisDto.class);
    }

    @PostMapping("estado")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
                //1                                                 //1
    public ResponseEstadoDto adicionarEstado(@Valid @RequestBody RequestEstadoDto request){
                                                  //1               //1
        var estado =mapper.map(request.toEntity(manager), Estado.class);
        manager.persist(estado);
        return mapper.map(estado, ResponseEstadoDto.class);
    }
}
