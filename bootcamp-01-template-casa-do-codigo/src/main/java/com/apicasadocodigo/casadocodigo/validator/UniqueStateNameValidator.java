package com.apicasadocodigo.casadocodigo.validator;

import com.apicasadocodigo.casadocodigo.model.State;
import com.apicasadocodigo.casadocodigo.request.StateRequest;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UniqueStateNameValidator implements Validator {

    @Autowired
    private GenericDAO genericDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return StateRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        StateRequest stateRequest = (StateRequest) object;

        boolean exists = genericDAO
                        .findEntityByAtribute(State.class, "name", stateRequest.getName());

        if(!exists){
            errors.reject("estado", null, "Já existe um(a) outro(a) estado com o nome "
            + stateRequest.getName());
        }
    }
}