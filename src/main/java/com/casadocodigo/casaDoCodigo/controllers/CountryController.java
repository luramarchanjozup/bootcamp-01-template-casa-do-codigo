package com.casadocodigo.casaDoCodigo.controllers;

import javax.validation.Valid;

import com.casadocodigo.casaDoCodigo.controllers.form.CountryForm;
import com.casadocodigo.casaDoCodigo.model.Country;
import com.casadocodigo.casaDoCodigo.services.validators.CheckDuplicatedCountry;
import com.casadocodigo.casaDoCodigo.services.CountryService;

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
    private CountryService countryService;
    @Autowired
    private CheckDuplicatedCountry checkDuplicatedCountry;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(checkDuplicatedCountry);
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody @Valid CountryForm form, UriComponentsBuilder uriBuilder) {
        return ResponseEntity.ok().body(countryService.createCountry(form));
    }
}
