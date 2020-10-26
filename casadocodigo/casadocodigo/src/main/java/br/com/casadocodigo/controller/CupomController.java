package br.com.casadocodigo.controller;

import br.com.casadocodigo.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CupomController {

    @Autowired
    private CupomRepository cupomRepository;


}

