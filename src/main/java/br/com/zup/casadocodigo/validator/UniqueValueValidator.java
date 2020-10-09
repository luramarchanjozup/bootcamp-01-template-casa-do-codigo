package br.com.zup.casadocodigo.validator;

import br.com.zup.casadocodigo.annotations.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String domainAttribute;
    private Class<?> theClass;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void initialize(UniqueValue value) {
        domainAttribute = value.fieldName();
        theClass = value.domainClass();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {

        Query query = entityManager.createQuery("select 1 from " + theClass.getName() + " where " + domainAttribute + " =:value");
        query.setParameter("value", obj);

        List<?> list = query.getResultList();
        Assert.state(list.size() <= 1, "já existe um elemento " + theClass + " com atributo o " + domainAttribute + "=" + obj);

        return list.isEmpty();
    }

}