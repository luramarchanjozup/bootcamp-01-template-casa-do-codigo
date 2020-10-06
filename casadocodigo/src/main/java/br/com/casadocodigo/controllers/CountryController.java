package br.com.casadocodigo.controllers;

import br.com.casadocodigo.forms.CountryForm;
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
@RequestMapping("/countries")
public class CountryController {

    //+1
    @Autowired
    private CountryRepository countryRepository;

    @PostMapping                                                            //+1
    public ResponseEntity<?> createCountry(@RequestBody @Valid CountryForm countryForm){

        //+1
        Country country = countryForm.toEntity();


        countryRepository.save(country);

        //+1
        return ResponseEntity.ok().build();

    }
}
