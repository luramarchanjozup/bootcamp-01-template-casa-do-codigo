package com.apicasadocodigo.casadocodigo.service.validator;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueConstrainte implements ConstraintValidator<UniqueValue, String> {

    //@PersistenceContext
    private EntityManager manager;

    private Class <?> entity;

    private String domainAttribute;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        entity = constraintAnnotation.entity();
        domainAttribute = constraintAnnotation.attributeName();
    }

    @Override
    public boolean isValid(String mustBeValid, ConstraintValidatorContext context) {

        String sql = String.format("SELECT t.%s FROM %s t WHERE t.%s =:value",
                domainAttribute, entity.getSimpleName(), domainAttribute
        );
        System.out.println(manager);
        Query query = manager.createQuery(sql);

        query.setParameter("value", mustBeValid);

        List<?> list = query.getResultList();

        return list.isEmpty();
    }
}
