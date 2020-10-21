package br.com.itau.casadocodigo.cadastropaisestado.controller;

import br.com.itau.casadocodigo.cadastropaisestado.model.*;
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
public class CadastroPaisEstadoController {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Contagem de carga intrínseca no Controller: 3
     * @param paisRequest recebe o país a ser cadastro
     * @return a criação do país com seu respectivo ID
     */
    @PostMapping(value = "/v1/pais")
    @Transactional
    public ResponseEntity<PaisResponse> cadastraPais(@RequestBody @Valid PaisRequest paisRequest) {
        Pais pais = paisRequest.toModel();
        entityManager.persist(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PaisResponse(pais));
    }

    /**
     * Contagem de carga intrínseca no Controller: 3
     * @param estadoRequest recebe o estado a ser cadastrado
     * @return a criação do estado com seu respectivo ID e país cadastrado
     */
    @PostMapping(value = "/v1/estado")
    @Transactional
    public ResponseEntity<EstadoResponse> cadastraEstado(@RequestBody @Valid EstadoRequest estadoRequest) {
        Estado estado = estadoRequest.toModel(entityManager);
        entityManager.persist(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(new EstadoResponse(estado));
    }
}
