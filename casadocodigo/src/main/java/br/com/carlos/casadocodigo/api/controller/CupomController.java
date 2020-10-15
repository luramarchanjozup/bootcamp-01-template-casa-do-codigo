package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.request.RequestCupomDto;
import br.com.carlos.casadocodigo.api.dto.request.RequestCupomUpdateDto;
import br.com.carlos.casadocodigo.api.dto.response.ResponseCupomDto;
import br.com.carlos.casadocodigo.domain.entity.Cupom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RequestMapping("/cupons")
@RestController
public class CupomController {

    @PersistenceContext
    private EntityManager manager;
    
    @Autowired
    private ModelMapper mapper;

    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
                //1                                              //1
    public ResponseCupomDto adicionar(@Valid @RequestBody RequestCupomDto request) {
                                                //1
        var cupom = mapper.map(request, Cupom.class);
        manager.persist(cupom);
        return mapper.map(cupom, ResponseCupomDto.class);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseCupomDto alterar(@PathVariable Long id, @Valid @RequestBody RequestCupomUpdateDto request){
        var cupomExistente = manager.find(Cupom.class, id);
        var cupomNovo = mapper.map(request, Cupom.class);
        cupomNovo.atualizaCupom(cupomExistente, cupomNovo);
        return mapper.map(manager.merge(cupomNovo), ResponseCupomDto.class);
    }
}
