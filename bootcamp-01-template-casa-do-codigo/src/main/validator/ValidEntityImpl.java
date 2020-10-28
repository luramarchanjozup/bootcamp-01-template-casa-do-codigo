package com.apicasadocodigo.casadocodigo.service.validator;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidEntityImpl implements ConstraintValidator<ValidEntityById, Long> {

    //@PersistenceContext
    private EntityManager manager;

    private  Class<?> entity;

    @Override
    public void initialize(ValidEntityById constraintAnnotation) {
        this.entity = constraintAnnotation.typeEntity();
    }

    @Override
    public boolean isValid(Long mustBeValid, ConstraintValidatorContext constraintValidatorContext) {

        String sql = String.format("SELECT 1 FROM %s t WHERE t.is =:id", entity.getSimpleName());

        Query query = manager.createQuery(sql);

        query.setParameter("id", mustBeValid);

        List<?> list = query.getResultList();

        return !list.isEmpty();
    }
}
