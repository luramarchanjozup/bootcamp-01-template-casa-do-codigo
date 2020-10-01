package com.github.marcoscoutozup.casadocodigo.fluxocompra.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CodigoUnicoDoCupomValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
