package dev.arielalvesdutrazup.cdc.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.CadastrarPaisRequestDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.PaisResponseDTO;
import dev.arielalvesdutrazup.cdc.entities.Pais;
import dev.arielalvesdutrazup.cdc.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping("/paises")
@RestController
public class PaisController {

    @Autowired
    private PaisService paisService;

    @PostMapping
    public ResponseEntity<PaisResponseDTO> cadastrar(
            @Valid @RequestBody CadastrarPaisRequestDTO cadastrarDto,
            UriComponentsBuilder uriBuilder){

        Pais paisCadastrado = paisService.cadastrar(cadastrarDto.paraEntidade());

        URI uri = uriBuilder.path("/paises/{id}")
                .buildAndExpand(paisCadastrado.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new PaisResponseDTO(paisCadastrado));
    }
}
