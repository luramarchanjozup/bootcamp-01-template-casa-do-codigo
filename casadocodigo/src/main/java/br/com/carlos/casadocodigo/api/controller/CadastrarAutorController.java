package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.RequestAutorDto;
import br.com.carlos.casadocodigo.api.dto.ResponseAutorDto;
import br.com.carlos.casadocodigo.domain.entity.Autor;
import br.com.carlos.casadocodigo.domain.repository.AutorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class CadastrarAutorController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseAutorDto adicionar(@Valid @RequestBody RequestAutorDto requestAutorDto) {
        Autor autor = modelMapper.map(requestAutorDto, Autor.class);
        return  modelMapper.map(autorRepository.save(autor), ResponseAutorDto.class);
    }
}
