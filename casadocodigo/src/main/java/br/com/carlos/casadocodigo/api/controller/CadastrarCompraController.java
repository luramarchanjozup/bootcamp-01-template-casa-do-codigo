package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.request.RequestCompraDto;
import br.com.carlos.casadocodigo.api.handler.CupomValidoValidator;
import br.com.carlos.casadocodigo.api.handler.EstadoPertenceAPaisValidator;
import br.com.carlos.casadocodigo.api.handler.VerificaDocumentoCpfCnpjValidator;
import br.com.carlos.casadocodigo.domain.entity.Compra;
import br.com.carlos.casadocodigo.domain.repository.CupomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CadastrarCompraController {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CupomValidoValidator cupomValidator;
    @Autowired
    private VerificaDocumentoCpfCnpjValidator documentoValidator;
    @Autowired
    private EstadoPertenceAPaisValidator estadoPaisValidator;
    @PersistenceContext
    private EntityManager manager;
    @Autowired              //1
    private CupomRepository cupomRepository;
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(cupomValidator, documentoValidator, estadoPaisValidator);
    }


    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("compras")                                             //1
    public ResponseEntity<?> adicionarCompra(@Valid @RequestBody RequestCompraDto request, UriComponentsBuilder uriComponentsBuilder){
                                                    //1                               //1
        var compra = mapper.map(request.toEntity(manager, cupomRepository), Compra.class);
        manager.persist(compra);
        return ResponseEntity.created(uriComponentsBuilder.path("/produtos/{id}").
                buildAndExpand(compra.getId()).toUri()).build();
    }
}
