package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Compra;
import br.com.treino.casadocodigo.repository.CupomRepositoy;
import br.com.treino.casadocodigo.request.NovaCompraRequest;
import br.com.treino.casadocodigo.validations.CupomValidoValidator;
import br.com.treino.casadocodigo.validations.EstadoPertenceAoPaisValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class CompraController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EstadoPertenceAoPaisValidator estadoPertenceAoPaisValidator;  //1

    @Autowired
    private CupomValidoValidator cupomValidoValidator;

    @Autowired
    CupomRepositoy cupomRepositoy;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(estadoPertenceAoPaisValidator,
                cupomValidoValidator);
    }

    @PostMapping(value = "/compra")
    public ResponseEntity<Compra> novoCliente(@RequestBody @Valid NovaCompraRequest request) { //2

        Compra compra = request.toModel(entityManager, cupomRepositoy);

        return new ResponseEntity(compra, HttpStatus.CREATED);
    }

}
