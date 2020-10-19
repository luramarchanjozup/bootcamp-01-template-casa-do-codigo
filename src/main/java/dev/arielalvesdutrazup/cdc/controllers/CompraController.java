package dev.arielalvesdutrazup.cdc.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.CompraRequestDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.CompraResponseDTO;
import dev.arielalvesdutrazup.cdc.entities.Compra;
import dev.arielalvesdutrazup.cdc.services.BuscarCompraService;
import dev.arielalvesdutrazup.cdc.services.FecharCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

// 1 CompraService.java
// 2 Compra.java
// 3 CompraRequestDTO.java
// 4 CompraResponseDTO.java

@RequestMapping("/compras")
@RestController
public class CompraController {

    @Autowired
    private FecharCompraService fecharCompraService;

    @Autowired
    private BuscarCompraService buscarCompraService;

    @PostMapping
    public ResponseEntity<CompraResponseDTO> fecharCompra(
            @Valid @RequestBody CompraRequestDTO requestDTO,
            UriComponentsBuilder uriBuilder){

        Compra compraCadastrada = fecharCompraService.fecharCompra(requestDTO);

        URI uri = uriBuilder.path("/compras/{id}")
                .buildAndExpand(compraCadastrada.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new CompraResponseDTO(compraCadastrada));
    }

    @RequestMapping(path = "/{compraId}", method = GET)
    public ResponseEntity<CompraResponseDTO> detalhe(@PathVariable Long compraId) {

        Compra compra = buscarCompraService.buscaPeloId(compraId);

        return ResponseEntity.ok().body(new CompraResponseDTO(compra));
    }
}
