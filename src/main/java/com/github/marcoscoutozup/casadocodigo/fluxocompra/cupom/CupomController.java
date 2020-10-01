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

    @Autowired //1
    private CupomRepository cupomRepository;

    @PostMapping
    @Transactional                                      //2
    public String cadastrarCupom(@RequestBody @Valid CupomDTO dto){
        //3
        Cupom cupom = dto.toModel();
        cupomRepository.save(cupom);
        return cupom.toString();
    }

    @PutMapping("/{id}")
    @Transactional                                                                  //4
    public ResponseEntity alterarCupom(@PathVariable UUID id, @RequestBody @Valid CupomDTOUpdate dto){
        Cupom cupom = cupomRepository.findById(id).orElse(null);

        //5
        if(cupom == null){
            return ResponseEntity.status(404).body("Cupom não encontrado");
        }

        //6
        if(!dto.validarCodigoDoCupom(cupom, cupomRepository)){
            return ResponseEntity.badRequest().body("O código não pode ser duplicado");
        }

        cupom = dto.updateCupom(cupom);
        cupomRepository.save(cupom);
        return ResponseEntity.ok(cupom.toString());
    }

}
