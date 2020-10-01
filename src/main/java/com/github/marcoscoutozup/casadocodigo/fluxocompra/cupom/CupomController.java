package com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/cupom")
public class CupomController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional                                      //1
    public String cadastrarCupom(@RequestBody @Valid CupomDTO dto){
        //2
        Cupom cupom = dto.toModel();
        entityManager.persist(cupom);
        return cupom.toString();
    }

    @PutMapping("/{id}")
    @Transactional                                                                  //3
    public ResponseEntity alterarCupom(@PathVariable UUID id, @RequestBody @Valid CupomDTOUpdate dto){
        Cupom cupom = entityManager.find(Cupom.class, id);

        //4
        if(cupom == null){
            return ResponseEntity.status(404).body("Cupom não encontrado");
        }

        //5
        if(dto.validarCodigoDoCupom(cupom, entityManager)){
            return ResponseEntity.badRequest().body("O código não pode ser duplicado");
        }

        cupom = dto.updateCupom(cupom);
        entityManager.merge(cupom);
        return ResponseEntity.ok(cupom.toString());
    }

}
