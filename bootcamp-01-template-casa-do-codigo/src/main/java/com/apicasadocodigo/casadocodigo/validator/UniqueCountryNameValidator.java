package com.apicasadocodigo.casadocodigo.validator;

import com.apicasadocodigo.casadocodigo.model.Country;
import com.apicasadocodigo.casadocodigo.request.CountryRequest;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UniqueCountryNameValidator implements Validator {

    @Autowired
    private GenericDAO genericDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return CountryRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CountryRequest countryRequest = (CountryRequest) object;

        boolean exists = genericDAO
                        .findEntityByAtribute(Country.class, "name", countryRequest.getName());

        if(!exists){
            errors.reject("país", null, "Já existe país com o nome "
            + countryRequest.getName());
        }
    }
}