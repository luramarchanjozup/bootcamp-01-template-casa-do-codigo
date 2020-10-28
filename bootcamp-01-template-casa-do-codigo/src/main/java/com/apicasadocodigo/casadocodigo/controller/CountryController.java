package com.apicasadocodigo.casadocodigo.controller;

import com.apicasadocodigo.casadocodigo.model.Country;
import com.apicasadocodigo.casadocodigo.request.CountryRequest;
import com.apicasadocodigo.casadocodigo.response.CountryResponse;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import com.apicasadocodigo.casadocodigo.validator.UniqueCountryNameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping("/countrys")
@RestController
public class CountryController {

    @Autowired   //1
    private GenericDAO genericDAO;

    @Autowired   //2
    private UniqueCountryNameValidator uniqueCountryNameValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(uniqueCountryNameValidator);
    }

    @PostMapping                                                 //3
    public ResponseEntity<?> saveCountry(@RequestBody @Valid CountryRequest request, UriComponentsBuilder builder) {

        Long id = genericDAO.saveEntity(request.toModel()).getId();
        URI uri = builder.path("/countrys/{id}").build(id);

        return ResponseEntity.ok(uri);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Long id){
            //4
        CountryResponse response = new CountryResponse(genericDAO.findEntityDyId(Country.class, id));
        return ResponseEntity.ok(response);
    }
    //Pontos CDD: 4
}
