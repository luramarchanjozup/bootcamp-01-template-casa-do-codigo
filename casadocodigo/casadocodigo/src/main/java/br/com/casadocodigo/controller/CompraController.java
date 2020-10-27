package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.Compra;
import br.com.casadocodigo.model.NovaCompraRequest;
import br.com.casadocodigo.repository.CupomRepository;
import br.com.casadocodigo.validator.CupomValidoValidator;
import br.com.casadocodigo.validator.EstadoPertenceAPaisValidator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CompraController {

    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private CupomRepository cupomRepository;
    @Autowired
    private CupomValidoValidator cupomValidoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new VerificaDocumentoCpfCnpjValidator(),estadoPertenceAPaisValidator,cupomValidoValidator);
    }

    @PostMapping(value = "/compras")
    @Transactional
    public String cria(@RequestBody @Valid NovaCompraRequest request) {

        Compra novaCompra = request.toModel(entityManager,cupomRepository);
        entityManager.persist(novaCompra);

        return novaCompra.toString();
    }
}
