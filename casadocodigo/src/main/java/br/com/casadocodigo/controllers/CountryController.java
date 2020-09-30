package br.com.casadocodigo.controllers;

import br.com.casadocodigo.dtos.CountryDto;
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

    @Autowired
    private CountryRepository countryRepository;

    @PostMapping
    public ResponseEntity<CountryDto> createCountry(@RequestBody @Valid CountryForm countryForm){

        Country country = countryForm.toEntity();

        if(country != null){
            countryRepository.save(country);
            return ResponseEntity.ok(new CountryDto(country));
        }

        return ResponseEntity.notFound().build();

    }
}
