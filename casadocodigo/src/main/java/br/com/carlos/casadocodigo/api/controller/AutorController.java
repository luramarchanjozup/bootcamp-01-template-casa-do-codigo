package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.RequestAutorDto;
import br.com.carlos.casadocodigo.api.dto.ResponseAutorDto;
import br.com.carlos.casadocodigo.domain.entity.Autor;
import br.com.carlos.casadocodigo.domain.service.impl.CadastroAutorServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/autor")
public class AutorController {

    private final ModelMapper modelMapper;
    private final CadastroAutorServiceImpl cadastroAutor;

    public AutorController(CadastroAutorServiceImpl cadastroAutor, ModelMapper modelMapper) {
        this.cadastroAutor = cadastroAutor;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseAutorDto adicionar(@Valid @RequestBody RequestAutorDto requestAutorDto) {
        Autor autor = toEntity(requestAutorDto);
        return  toDto(cadastroAutor.salvar(autor));    }

    public ResponseAutorDto toDto(Autor autor){
        return modelMapper.map(autor, ResponseAutorDto.class);
    }

    public Autor toEntity(RequestAutorDto autor){
        return modelMapper.map(autor, Autor.class);
    }

}
