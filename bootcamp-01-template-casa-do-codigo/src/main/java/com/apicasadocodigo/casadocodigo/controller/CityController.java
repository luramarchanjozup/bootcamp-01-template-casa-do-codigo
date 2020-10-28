package com.apicasadocodigo.casadocodigo.controller;

import com.apicasadocodigo.casadocodigo.model.City;
import com.apicasadocodigo.casadocodigo.model.State;
import com.apicasadocodigo.casadocodigo.request.CityRequest;
import com.apicasadocodigo.casadocodigo.response.CityResponse;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import com.apicasadocodigo.casadocodigo.validator.UniqueCityNameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired   //1
    private GenericDAO genericDAO;

    @Autowired
    private UniqueCityNameValidator uniqueCityNameValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(uniqueCityNameValidator);
    }

    @PostMapping
    @Transactional                                          //1
    public ResponseEntity<?> saveCity(@RequestBody @Valid CityRequest request, UriComponentsBuilder builder) {

        State state = genericDAO.findEntityDyId(State.class, request.getState().getId());

        request.setState(state);

        Long idAddress = genericDAO.saveEntity(request.toModel()).getId();

        URI addressConsult = builder.path("/authors/{id}").build(idAddress);

        return ResponseEntity.created(addressConsult).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getCity(@PathVariable Long id){
        //4
        CityResponse response = new CityResponse(genericDAO.findEntityDyId(City.class, id));

        return ResponseEntity.ok(response);
    }
    //Pontos CDD: 4
}
