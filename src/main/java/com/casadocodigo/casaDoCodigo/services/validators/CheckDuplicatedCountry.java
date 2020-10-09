package com.casadocodigo.casaDoCodigo.services.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

import com.casadocodigo.casaDoCodigo.controllers.form.CountryForm;
import com.casadocodigo.casaDoCodigo.model.Country;
import com.casadocodigo.casaDoCodigo.repositories.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckDuplicatedCountry implements Validator {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CountryForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CountryForm request = (CountryForm) target;

        Optional<Country> possibleCountry = countryRepository.findByName(request.getName());

        if(possibleCountry.isPresent()) {
            errors.rejectValue("name", null, "Country with name " + request.getName() + " already exists");
        }
    }
    
}
