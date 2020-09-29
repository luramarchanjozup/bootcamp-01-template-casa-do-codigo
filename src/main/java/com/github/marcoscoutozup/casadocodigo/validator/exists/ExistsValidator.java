package com.github.marcoscoutozup.casadocodigo.validator.exists;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;

public class ExistsValidator implements ConstraintValidator<Exists, UUID> {

    @PersistenceContext
    private EntityManager entityManager;

    private String classe;

    @Override
    public void initialize(Exists constraintAnnotation) {
        classe = constraintAnnotation.classe().getSimpleName();
    }

    @Override
    public boolean isValid(UUID uuid, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select 1 from " + classe + " where id = :uuid");
        query.setParameter("uuid", uuid);
        return !query.getResultList().isEmpty();
    }
}
