package br.com.ecommerce.cdc.controller;

import br.com.ecommerce.cdc.domain.request.CadastroRequest;
import br.com.ecommerce.cdc.validation.EstadoPertecePaisValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/v2/cadastro")
public class CadastroController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private EstadoPertecePaisValidator estadoPertecePaisValidator;

    @InitBinder
    protected void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(estadoPertecePaisValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> criaCadastro(@RequestBody @Validated CadastroRequest cadastroRequest){

        System.out.println(cadastroRequest);


        return ResponseEntity.ok().build();
    }
}
