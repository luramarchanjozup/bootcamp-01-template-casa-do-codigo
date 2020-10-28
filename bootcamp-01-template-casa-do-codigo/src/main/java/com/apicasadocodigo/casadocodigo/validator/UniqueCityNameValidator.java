package com.apicasadocodigo.casadocodigo.validator;

import com.apicasadocodigo.casadocodigo.model.City;
import com.apicasadocodigo.casadocodigo.request.CityRequest;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UniqueCityNameValidator implements Validator {

    @Autowired
    private GenericDAO genericDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return CityRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CityRequest cityRequest = (CityRequest) object;

        boolean exists = genericDAO
                        .findEntityByAtribute(City.class, "name", cityRequest.getName());

        if(!exists){
            errors.reject("cidade", null, "Já existe um(a) outro(a) cidade com o nome "
            + cityRequest.getName());
        }
    }
}