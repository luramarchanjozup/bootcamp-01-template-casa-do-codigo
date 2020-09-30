package com.casadocodigo.casaDoCodigo.controllers;

import java.net.URI;

import javax.validation.Valid;

import com.casadocodigo.casaDoCodigo.controllers.form.CountryForm;
import com.casadocodigo.casaDoCodigo.model.Country;
import com.casadocodigo.casaDoCodigo.services.validators.CheckDuplicatedCountry;
import com.casadocodigo.casaDoCodigo.services.CountryService;

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

    @GetMapping("/{name}")
    public ResponseEntity<Country> detailedIndex(@PathVariable @Valid String name) {
        Country country = countryService.detailedIndex(name);
        return ResponseEntity.ok().body(country);
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody @Valid CountryForm form, UriComponentsBuilder uriBuilder) {
        Country country = countryService.createCountry(form);
        URI uri = uriBuilder.path("country/{name}").buildAndExpand(country.getName()).toUri();
        return ResponseEntity.created(uri).body(country);
    }
}
