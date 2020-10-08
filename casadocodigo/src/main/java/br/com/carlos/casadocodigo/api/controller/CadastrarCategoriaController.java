package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.RequestCategoriaDto;
import br.com.carlos.casadocodigo.api.dto.ResponseCategoriaDto;
import br.com.carlos.casadocodigo.domain.entity.Categoria;
import br.com.carlos.casadocodigo.domain.repository.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CadastrarCategoriaController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseCategoriaDto adicionar(@Valid @RequestBody RequestCategoriaDto request){
        var categoria = mapper.map(request, Categoria.class);
        return mapper.map(repository.save(categoria),ResponseCategoriaDto.class);
    }
}
