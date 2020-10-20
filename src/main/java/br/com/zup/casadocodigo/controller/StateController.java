package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.domain.State;
import br.com.zup.casadocodigo.dto.StateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class StateController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/state")
    @Transactional
    public ResponseEntity<?> createState (@RequestBody @Valid StateDTO stateDTO) {
        State newState = stateDTO.toModel(entityManager);
        entityManager.persist(newState);
        return ResponseEntity.status(HttpStatus.CREATED).body(newState);
    }
}
