package com.casadocodigo.casaDoCodigo.services.validators;

import java.util.Optional;

import com.casadocodigo.casaDoCodigo.controllers.form.StateForm;
import com.casadocodigo.casaDoCodigo.model.State;
import com.casadocodigo.casaDoCodigo.repositories.StateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CheckDuplicatedState implements Validator {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return StateForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        StateForm request = (StateForm) target;

        Optional<State> possibleState = stateRepository.findByName(request.getName());
        if (possibleState.isPresent()) {
            errors.rejectValue("name", null, "State with name " + request.getName() + " already exists");
        }
    }
    
}
