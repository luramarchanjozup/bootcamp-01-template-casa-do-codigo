package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.domain.Buyer;
import br.com.zup.casadocodigo.dto.BuyerDTO;
import br.com.zup.casadocodigo.validator.CpfCnpjValidator;
import br.com.zup.casadocodigo.validator.StateBelongsCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/buy")
public class BuyerController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private StateBelongsCountry stateBelongsCountry;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new CpfCnpjValidator(),stateBelongsCountry);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> register(@RequestBody @Valid BuyerDTO buyerDTO) {
        Buyer newBuyer = buyerDTO.toModel(entityManager);
        entityManager.persist(newBuyer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBuyer);

    }

}
