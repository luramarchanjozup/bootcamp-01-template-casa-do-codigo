package dev.arielalvesdutrazup.cdc.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.CompraRequestDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.CompraResponseDTO;
import dev.arielalvesdutrazup.cdc.entities.Compra;
import dev.arielalvesdutrazup.cdc.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping("/compras")
@RestController
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<CompraResponseDTO> fecharCompra(
            @Valid @RequestBody CompraRequestDTO requestDTO,
            UriComponentsBuilder uriBuilder){

        Compra compraCadastrada = compraService.fecharCompra(requestDTO);

        URI uri = uriBuilder.path("/compras/{id}")
                .buildAndExpand(compraCadastrada.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new CompraResponseDTO(compraCadastrada));
    }

    @RequestMapping(path = "/{compraId}", method = GET)
    public ResponseEntity<CompraResponseDTO> detalhe(@PathVariable Long compraId) {

        Compra compra = compraService.buscaPeloId(compraId);

        return ResponseEntity.ok().body(new CompraResponseDTO(compra));
    }
}
