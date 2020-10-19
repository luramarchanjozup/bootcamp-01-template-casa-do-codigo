package dev.arielalvesdutrazup.cdc.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.CategoriaResponseDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.CadastrarCategoriaRequestDTO;
import dev.arielalvesdutrazup.cdc.entities.Categoria;
import dev.arielalvesdutrazup.cdc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

// 1 CategoriaService.java
// 2 CategoriaResponseDTO.java
// 3 Categoria.java
// 4 CadastrarCategoriaRequestDTO.java

@RequestMapping("/categorias")
@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> cadastrar(
            @Valid @RequestBody CadastrarCategoriaRequestDTO cadastrarDto,
            UriComponentsBuilder uriBuilder){

        Categoria categoriaCadastrada = categoriaService.cadastrar(cadastrarDto.paraEntidade());

        URI uri = uriBuilder.path("/categorias/{id}")
                .buildAndExpand(categoriaCadastrada.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new CategoriaResponseDTO(categoriaCadastrada));
    }
}
