package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Compra;
import br.com.treino.casadocodigo.repository.CupomRepositoy;
import br.com.treino.casadocodigo.request.NovaCompraRequest;
import br.com.treino.casadocodigo.validations.CupomValidoValidator;
import br.com.treino.casadocodigo.validations.EstadoPertenceAoPaisValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/compras")
public class CompraNovaController {

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    CupomRepositoy cupomRepositoy; //1
    @Autowired
    private EstadoPertenceAoPaisValidator estadoPertenceAoPaisValidator; //2
    @Autowired
    private CupomValidoValidator cupomValidoValidator; //3

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(estadoPertenceAoPaisValidator,
                cupomValidoValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity novoCliente(@RequestBody @Valid NovaCompraRequest request) { //4

        Compra novaCompra = request.toModel(entityManager, cupomRepositoy);  //5
        entityManager.persist(novaCompra);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
