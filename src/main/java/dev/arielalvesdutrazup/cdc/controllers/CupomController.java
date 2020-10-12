package dev.arielalvesdutrazup.cdc.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.AlterarCupomRequestDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.CadastrarCupomRequestDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.CupomResponseDTO;
import dev.arielalvesdutrazup.cdc.entities.Cupom;
import dev.arielalvesdutrazup.cdc.services.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RequestMapping("/cupons")
@RestController
public class CupomController {

    @Autowired
    private CupomService cupomService;

    @PostMapping
    public ResponseEntity<CupomResponseDTO> cadastrar(
            @Valid @RequestBody CadastrarCupomRequestDTO cadastrarDto,
            UriComponentsBuilder uriBuilder){

        Cupom cupomCadastrado = cupomService.cadastrar(cadastrarDto.paraEntidade());

        URI uri = uriBuilder.path("/cupons/{id}")
                .buildAndExpand(cupomCadastrado.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new CupomResponseDTO(cupomCadastrado));
    }

    @RequestMapping(path = "/{id}", method = PUT)
    public ResponseEntity<CupomResponseDTO> alterar(
            @PathVariable Long id,
            @Valid @RequestBody AlterarCupomRequestDTO cadastrarDto,
            UriComponentsBuilder uriBuilder){

        Cupom cupomAlterado = cupomService.alterar(id, cadastrarDto.paraEntidade());

        return ResponseEntity.ok().body(new CupomResponseDTO(cupomAlterado));
    }
}
