package com.casadocodigo.casaDoCodigo.services;

import javax.transaction.Transactional;

import com.casadocodigo.casaDoCodigo.controllers.form.CountryForm;
import com.casadocodigo.casaDoCodigo.model.Country;
import com.casadocodigo.casaDoCodigo.repositories.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    
    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public Country createCountry(CountryForm form) {
        Country country = new Country(form.getName());
        countryRepository.save(country);

        return country;
    }

}
