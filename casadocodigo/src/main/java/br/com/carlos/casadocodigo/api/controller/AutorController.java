package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.RequestAutorDto;
import br.com.carlos.casadocodigo.api.dto.ResponseAutorDto;
import br.com.carlos.casadocodigo.api.handler.EmailDuplicadoValidator;
import br.com.carlos.casadocodigo.domain.entity.Autor;
import br.com.carlos.casadocodigo.domain.service.impl.CadastroAutorServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final ModelMapper modelMapper;
    private final CadastroAutorServiceImpl cadastroAutor;
    private final EmailDuplicadoValidator emailDuplicadoValidator;

    public AutorController(CadastroAutorServiceImpl cadastroAutor, ModelMapper modelMapper, EmailDuplicadoValidator emailDuplicadoValidator) {
        this.cadastroAutor = cadastroAutor;
        this.modelMapper = modelMapper;
        this.emailDuplicadoValidator = emailDuplicadoValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(emailDuplicadoValidator);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseAutorDto adicionar(@Valid @RequestBody RequestAutorDto requestAutorDto) {
        Autor autor = modelMapper.map(requestAutorDto, Autor.class);
        return  modelMapper.map(cadastroAutor.salvar(autor), ResponseAutorDto.class);
    }
}
