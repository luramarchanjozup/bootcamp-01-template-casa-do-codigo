package com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/cupom")
public class CupomController {

    @Autowired
    private CupomRepository cupomRepository;

    @PostMapping
    @Transactional                                      //1
    public String cadastrarCupom(@RequestBody @Valid CupomDTO dto){
        //2
        Cupom cupom = dto.toModel();
        cupomRepository.save(cupom);
        return cupom.toString();
    }

    @PutMapping("/{id}")
    @Transactional                                                                  //3
    public ResponseEntity alterarCupom(@PathVariable UUID id, @RequestBody @Valid CupomDTOUpdate dto){
        Cupom cupom = cupomRepository.findById(id).orElse(null);

        //4
        if(cupom == null){
            return ResponseEntity.status(404).body("Cupom não encontrado");
        }

        //5
        if(!dto.validarCodigoDoCupom(cupom, cupomRepository)){
            return ResponseEntity.badRequest().body("O código não pode ser duplicado");
        }

        cupom = dto.updateCupom(cupom);
        cupomRepository.save(cupom);
        return ResponseEntity.ok(cupom.toString());
    }

}
