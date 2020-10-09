package br.com.zup.casadocodigo.validator;

import br.com.zup.casadocodigo.annotations.ExistsValue;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsValueValidator implements ConstraintValidator<ExistsValue, Object> {

    @PersistenceContext
    private EntityManager entityManager;

    private String domainAttribute;
    private Class<?> theClass;

    @Override
    public void initialize(ExistsValue params) {
        domainAttribute  = params.fieldName();
        theClass  = params.domainClass();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + theClass.getName() + " WHERE " + domainAttribute + " = :value");
        query.setParameter("value", obj);

        List<?> result = query.getResultList();

        Assert.state(result.size() <= 1, "more than one was found "+theClass+" \n" +
                " with the attribute"+domainAttribute+ " = "+ obj);
        return !result.isEmpty();


    }
}
