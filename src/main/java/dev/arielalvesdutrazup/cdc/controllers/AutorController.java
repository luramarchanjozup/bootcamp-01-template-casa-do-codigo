package dev.arielalvesdutrazup.cdc.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.AutorResponseDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.CadastrarAutorRequestDTO;
import dev.arielalvesdutrazup.cdc.entities.Autor;
import dev.arielalvesdutrazup.cdc.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

// 1 AutorService.java
// 2 CadsatrarAutorRequestDTO.java
// 3 Autor.java
// 4 AutorResponseDTO.java

@RequestMapping("/autores")
@RestController
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorResponseDTO> cadastrar(
            @Valid @RequestBody CadastrarAutorRequestDTO cadastrarDto,
            UriComponentsBuilder uriBuilder){

        Autor autorCadastrado = autorService.cadastrar(cadastrarDto.paraEntidade());

        URI uri = uriBuilder.path("/autores/{id}")
                .buildAndExpand(autorCadastrado.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new AutorResponseDTO(autorCadastrado));
    }
}
