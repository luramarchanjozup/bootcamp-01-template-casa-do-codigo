package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Compra;
import br.com.treino.casadocodigo.repository.CupomRepositoy;
import br.com.treino.casadocodigo.request.DetalheCompraRequest;
import br.com.treino.casadocodigo.request.NovaCompraRequest;
import br.com.treino.casadocodigo.validations.CupomValidoValidator;
import br.com.treino.casadocodigo.validations.EstadoPertenceAoPaisValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/compras")
public class CompraController {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private EstadoPertenceAoPaisValidator estadoPertenceAoPaisValidator;  //1
    @Autowired
    private CupomValidoValidator cupomValidoValidator; //2
    @Autowired
    CupomRepositoy cupomRepositoy; //3

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(estadoPertenceAoPaisValidator,
                cupomValidoValidator);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Compra> consultarCompra(@PathVariable("id") Long id){

        Compra novaCompra = entityManager.find(Compra.class, id);

        if (!ObjectUtils.isEmpty(novaCompra)){

            DetalheCompraRequest detalheCompraRequest =
                    new DetalheCompraRequest(novaCompra);

            return new ResponseEntity(detalheCompraRequest,
                    HttpStatus.OK);
        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping
    @Transactional
    public ResponseEntity<Compra> novoCliente(@RequestBody @Valid NovaCompraRequest request) { //4

        Compra novaCompra = request.toModel(entityManager, cupomRepositoy); //5

        entityManager.persist(novaCompra);

        return new ResponseEntity(novaCompra, HttpStatus.CREATED);
    }

}
