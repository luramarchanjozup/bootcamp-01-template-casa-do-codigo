package com.apicasadocodigo.casadocodigo.constraintvalidator;

import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String domainAttribute;
    private Class<?> entity;

    @Autowired
    private GenericDAO genericDAO;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        /*inicializa os atributos*/
        this.domainAttribute = constraintAnnotation.attributeName();
        this.entity = constraintAnnotation.entity();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

       Optional optional = Optional.ofNullable(genericDAO.findEntityByAtribute(entity, domainAttribute, value.toString()));

       return optional.isEmpty();
    }
}
