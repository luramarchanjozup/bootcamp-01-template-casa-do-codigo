package com.casadocodigo.casaDoCodigo.controllers;

import javax.validation.Valid;

import com.casadocodigo.casaDoCodigo.controllers.form.CountryForm;
import com.casadocodigo.casaDoCodigo.model.Country;
import com.casadocodigo.casaDoCodigo.repositories.CountryRepository;
import com.casadocodigo.casaDoCodigo.services.validators.CheckDuplicatedCountry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/country")
public class CountryController {
    
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CheckDuplicatedCountry checkDuplicatedCountry;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(checkDuplicatedCountry);
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody @Valid CountryForm form, UriComponentsBuilder uriBuilder) {
        Country country = new Country(form.getName());
        countryRepository.save(country);

        return ResponseEntity.ok().body(country);
    }
}
