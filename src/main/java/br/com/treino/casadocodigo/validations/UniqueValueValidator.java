package br.com.treino.casadocodigo.validations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> { //1

    private Class<?> nomeClass;
    private String nomeCampo;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        nomeClass = constraintAnnotation.className();
        nomeCampo = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Query query = entityManager.createQuery("select 1 from " + nomeClass.getName()+
                " where " + nomeCampo + "=:value");
        query.setParameter("value", value);

        return query.getResultList().isEmpty();
    }
}
