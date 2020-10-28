package com.apicasadocodigo.casadocodigo.controller;

import com.apicasadocodigo.casadocodigo.model.Country;
import com.apicasadocodigo.casadocodigo.model.State;
import com.apicasadocodigo.casadocodigo.request.StateRequest;
import com.apicasadocodigo.casadocodigo.response.StateResponse;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import com.apicasadocodigo.casadocodigo.validator.UniqueStateNameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired  //1      //2
    private GenericDAO genericDAO;

    @Autowired
    private UniqueStateNameValidator uniqueStateNameValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(uniqueStateNameValidator);
    }

    @PostMapping
        @Transactional                                               //3
        public ResponseEntity<?> saveCountry(@RequestBody @Valid StateRequest request, UriComponentsBuilder builder) {

            //4
            Country country = genericDAO.findEntityDepedenceDyId(Country.class, request.getCountryId());

            request.setCountry(country);

            Long id = genericDAO.saveEntity(request.toModel()).getId();
            URI uri = builder.path("states/{id}").build(id);

            return ResponseEntity.created(uri).build();

        }

        @GetMapping(value = "/{id}")
        public ResponseEntity<?> getCategory(@PathVariable Long id){
                 //5
            StateResponse response = new StateResponse(genericDAO.findEntityDyId(State.class, id));
            return ResponseEntity.ok(response);
        }
        //Pontos CDD: 5
}
