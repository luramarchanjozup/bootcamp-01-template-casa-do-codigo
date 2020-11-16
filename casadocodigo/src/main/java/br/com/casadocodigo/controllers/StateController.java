package br.com.casadocodigo.controllers;

import br.com.casadocodigo.forms.StateForm;
import br.com.casadocodigo.models.State;
import br.com.casadocodigo.repositories.StateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/states")
public class StateController {


    /* pontos de dificuldade de entendimento =  3 */

    /* @complexidade (1) - acoplamento contextual */
    private final StateRepository stateRepository;

    private final Logger logger = LoggerFactory.getLogger(State.class);


    public StateController(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }


    @PostMapping
    public ResponseEntity<?> createState(@RequestBody @Valid StateForm stateForm, UriComponentsBuilder
                                         uriComponentsBuilder){

        /* @complexidade (2) - método em classe específica do projeto */
        var state = stateForm.toEntity();
        stateRepository.save(state);

        logger.info("[INFO] Estado {} criado.", state.getName());

        return ResponseEntity
                .created(uriComponentsBuilder.path("/api/states").buildAndExpand().toUri())
                .build();

    }
}
