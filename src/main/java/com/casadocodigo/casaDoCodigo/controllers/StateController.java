package com.casadocodigo.casaDoCodigo.controllers;

import javax.validation.Valid;

import com.casadocodigo.casaDoCodigo.controllers.form.StateForm;
import com.casadocodigo.casaDoCodigo.model.State;
import com.casadocodigo.casaDoCodigo.services.StateServices;
import com.casadocodigo.casaDoCodigo.services.validators.CheckDuplicatedState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/state")
public class StateController {
    
    @Autowired
    private StateServices stateServices;
    @Autowired
    private CheckDuplicatedState checkDuplicatedState;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(checkDuplicatedState);
    }

    @GetMapping("/{name}")
    public ResponseEntity<State> detailedIndex(@PathVariable @Valid String name) {
        return ResponseEntity.ok().body(stateServices.detailedIndex(name));
    }

    @PostMapping
    public ResponseEntity<State> createState(@RequestBody @Valid StateForm form, UriComponentsBuilder uriBuilder) {
        return ResponseEntity.ok().body(stateServices.createState(form));
    }
}
