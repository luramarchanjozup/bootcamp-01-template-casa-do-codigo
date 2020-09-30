package br.com.casadocodigo.controllers;

import br.com.casadocodigo.dtos.StateDto;
import br.com.casadocodigo.forms.StateForm;
import br.com.casadocodigo.models.State;
import br.com.casadocodigo.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @PostMapping
    public ResponseEntity<StateDto> createState(@RequestBody @Valid StateForm stateForm){

        State state = stateForm.toEntity();

        if(state != null){
            stateRepository.save(state);
            return ResponseEntity.ok(new StateDto(state));
        }

        return ResponseEntity.notFound().build();

    }
}
