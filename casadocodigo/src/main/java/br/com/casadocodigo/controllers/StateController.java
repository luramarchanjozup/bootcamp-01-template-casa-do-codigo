package br.com.casadocodigo.controllers;

import br.com.casadocodigo.models.State;
import br.com.casadocodigo.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    public ResponseEntity<State> createState(@RequestBody @Valid State state){
        return ResponseEntity.ok(state);
    }

}
