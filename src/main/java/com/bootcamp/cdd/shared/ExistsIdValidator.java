package com.bootcamp.cdd.shared;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {
    private String domainAttribute;
    private Class<?> aClass;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(ExistsId params) {
        domainAttribute = params.fieldName();
        aClass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) return true;
        Query query = entityManager.createQuery("SELECT 1 FROM "+aClass.getName()+" WHERE "+domainAttribute+" =:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.isTrue(list.size() <=1, "voce tem mais de uma classe com o atributo "+domainAttribute+" com valor = "+value);
        return !list.isEmpty();
    }
}
