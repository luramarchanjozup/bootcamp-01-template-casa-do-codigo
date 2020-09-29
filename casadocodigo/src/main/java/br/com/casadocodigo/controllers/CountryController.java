package br.com.casadocodigo.controllers;

import br.com.casadocodigo.models.Country;
import br.com.casadocodigo.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody @Valid Country country){
        return ResponseEntity.ok(country);
    }

}
