package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.DadosCompradorRequest;
import br.com.zup.treinocasadocodigo.validators.EstadoValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Contagem de carga intrínseca da classe: 1
 */

@RestController
public class CompraController {

    @Autowired
    private EstadoValidador estadoValidador;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoValidador);
    }

    @PostMapping("/comprador")
    //1
    public String dadosComprador(@RequestBody @Valid DadosCompradorRequest dadosComprador) {
        return dadosComprador.toString();
    }
}
