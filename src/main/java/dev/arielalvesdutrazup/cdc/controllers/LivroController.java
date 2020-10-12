package dev.arielalvesdutrazup.cdc.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.CadastrarLivroRequestDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.LivroDetalheResponseDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.LivroResponseDTO;
import dev.arielalvesdutrazup.cdc.entities.Livro;
import dev.arielalvesdutrazup.cdc.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping("/livros")
@RestController
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroResponseDTO> cadastrar(
            @Valid @RequestBody CadastrarLivroRequestDTO cadastrarDto,
            UriComponentsBuilder uriBuilder){

        Livro livroCadastrado = livroService.cadastrar(
                cadastrarDto.getAutorId(),
                cadastrarDto.getCategoriaId(),
                cadastrarDto.paraEntidade());

        URI uri = uriBuilder.path("/livros/{id}")
                .buildAndExpand(livroCadastrado.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new LivroResponseDTO(livroCadastrado));
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> listarTodos() {
        List<Livro> livros = livroService.buscaTodos();

        return ResponseEntity.ok().body(LivroResponseDTO.paraDTO(livros));
    }

    @RequestMapping(path = "/{livroId}", method = GET)
    public ResponseEntity<LivroDetalheResponseDTO> detalhe(@PathVariable Long livroId) {
        Livro livro = livroService.buscaPeloId(livroId);

        return ResponseEntity.ok().body(new LivroDetalheResponseDTO(livro));
    }
}
