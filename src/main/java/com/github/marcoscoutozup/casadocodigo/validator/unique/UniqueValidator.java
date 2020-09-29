package com.github.marcoscoutozup.casadocodigo.validator.unique;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

    @PersistenceContext
    private EntityManager entityManager;

    private String classe;
    private String campo;

    @Override
    public void initialize(Unique constraintAnnotation) {
        classe = constraintAnnotation.classe().getSimpleName();
        campo = constraintAnnotation.campo();
    }

    @Override
    @Transactional
    public boolean isValid(String valor, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select 1 from " + classe + " where " + campo + " = :valor");
        query.setParameter("valor", valor);
        return query.getResultList().isEmpty();
    }
}
