package dev.arielalvesdutrazup.cdc.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.CadastrarEstadoRequestDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.EstadoResponseDTO;
import dev.arielalvesdutrazup.cdc.entities.Estado;
import dev.arielalvesdutrazup.cdc.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @RequestMapping(path = "/paises/{paisId}/estados", method = POST)
    public ResponseEntity<EstadoResponseDTO> cadastrar(
            @PathVariable Long paisId,
            @Valid @RequestBody CadastrarEstadoRequestDTO cadastrarDto,
            UriComponentsBuilder uriBuilder){

        Estado estadoCadastrado = estadoService.cadastrar(paisId, cadastrarDto.paraEntidade());

        URI uri = criaURIPaisEstado(uriBuilder, paisId, estadoCadastrado.getId());

        return ResponseEntity.created(uri).body(new EstadoResponseDTO(estadoCadastrado));
    }

    /**
     * Cria a URI do estado com o ID do pais e ID do estado.
     *
     * @param uriBuilder
     * @param paisId
     * @param estadoId
     * @return
     */
    private URI criaURIPaisEstado(
            UriComponentsBuilder uriBuilder,
            Long paisId,
            Long estadoId) {

        Map<String, Long> pathParams = new HashMap<>();

        pathParams.put("paisId", paisId);
        pathParams.put("estadoId", estadoId);

        return uriBuilder.path("/paises/{paisId}/estados/{estadoId}")
                .buildAndExpand(pathParams)
                .toUri();
    }
}
