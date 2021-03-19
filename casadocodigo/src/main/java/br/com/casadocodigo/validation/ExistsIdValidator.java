package br.com.casadocodigo.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {


    @PersistenceContext
    private EntityManager entityManager;

    // +1
    private String domainAttribute;

    // +1
    private Class<?> klass;


    @Override
    public void initialize(ExistsId constraintAnnotation) {

        // +1
        domainAttribute = constraintAnnotation.fieldName();

        // +1
        klass = constraintAnnotation.domainClass();

    }

    @Override
    public boolean isValid(Object id, ConstraintValidatorContext constraintValidatorContext) {

        // +1
        return !entityManager
                    .createQuery("select 1 from "+ klass.getName() +" where "+ domainAttribute + "=:value")
                    .setParameter("value", id)
                    .getResultList()
                    .isEmpty();

    }
}
