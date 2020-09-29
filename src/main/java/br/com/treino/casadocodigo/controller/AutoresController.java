package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Autor;
import br.com.treino.casadocodigo.model.NovoAutorRequest;
import br.com.treino.casadocodigo.repository.AutorRepository;
import br.com.treino.casadocodigo.validations.EmailDuplicadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AutoresController {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private EmailDuplicadoValidator emailDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(emailDuplicadoValidator);
    }

    @GetMapping(value = "/")
    public String home(){
        return "Tudo Ok!";
    }

    @PostMapping(value = "/autores")
    public String novoAutor(@RequestBody @Valid NovoAutorRequest request){
        Autor autor = request.toModel();
        autorRepository.save(autor);
        return autor.toString();
    }


}
