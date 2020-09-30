package com.casadocodigo.casaDoCodigo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.casadocodigo.casaDoCodigo.controllers.form.StateForm;
import com.casadocodigo.casaDoCodigo.model.Country;
import com.casadocodigo.casaDoCodigo.model.State;
import com.casadocodigo.casaDoCodigo.repositories.CountryRepository;
import com.casadocodigo.casaDoCodigo.repositories.StateRepository;
import com.casadocodigo.casaDoCodigo.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServices {
    
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CountryRepository countryRepository;

    public State detailedIndex(String name) {
        Optional<State> stateObj = stateRepository.findByName(name);
        return stateObj.orElseThrow(() -> new ObjectNotFoundException(exceptionMsg(name, "State")));
    }

    @Transactional
    public State createState(StateForm form) {
        Optional<Country> countryObj = countryRepository.findByName(form.getCountry());
        System.out.println(countryObj.isPresent());
        State state = new State(form.getName(), 
                                countryObj.orElseThrow(() -> new ObjectNotFoundException(exceptionMsg(form.getCountry(), "Country"))));
        
        stateRepository.save(state);

        return state;
    }

    private String exceptionMsg(String name, String type) {
        return (type + " of name " + name + " not found");
    }
}
