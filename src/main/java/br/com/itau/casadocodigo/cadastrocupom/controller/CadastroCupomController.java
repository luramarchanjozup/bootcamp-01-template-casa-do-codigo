package br.com.itau.casadocodigo.cadastrocupom.controller;

import br.com.itau.casadocodigo.cadastrocupom.model.Cupom;
import br.com.itau.casadocodigo.cadastrocupom.model.CupomAlteradoRequest;
import br.com.itau.casadocodigo.cadastrocupom.model.CupomRequest;
import br.com.itau.casadocodigo.cadastrocupom.model.CupomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CadastroCupomController {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Contagem de carga intrínseca no Controller: 3
     * @param cupomRequest recebe os dados do cupom para serem salvos
     * @return o cupom gravado
     */
    @PostMapping("/v1/cupom")
    @Transactional
    public ResponseEntity<CupomResponse> cadastraCupom(@RequestBody @Valid CupomRequest cupomRequest) {
        Cupom cupom = cupomRequest.toModel();
        entityManager.persist(cupom);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CupomResponse(cupom));
    }

    /**
     * Contagem de carga intrínseca no Controller: 1
     * @param cupomAlteradoRequest recebe os dados do cupom para serem alterados
     * @param id identificador do cupom a ser alterado
     * @return o cupom gravado
     */
    @PatchMapping("/v1/cupom/{id}")
    @Transactional
    public ResponseEntity<CupomResponse> alteraCupom(@RequestBody @Valid CupomAlteradoRequest cupomAlteradoRequest, @PathVariable("id") Long id) {
        Cupom cupom = cupomAlteradoRequest.toModel();
        cupom.atualizaCupom(id, entityManager);

        if (cupom.getId() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(new CupomResponse(cupom));
    }
}
