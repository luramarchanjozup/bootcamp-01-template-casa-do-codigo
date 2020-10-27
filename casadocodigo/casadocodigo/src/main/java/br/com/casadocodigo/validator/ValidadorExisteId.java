package br.com.casadocodigo.validator;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidadorExisteId implements ConstraintValidator<ExisteId, Object> {

    private String domainAttribute;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExisteId params){
        domainAttribute = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context){


        Query query = manager.createQuery("Select 1 from " + klass.getName() +
                " where " + domainAttribute + " = :value");
        query.setParameter("value", value);

        List<?> list = query.getResultList();
        Assert.state(list.size() <= 1, "Foi encontrado mais de um " +
                        klass + " com o atributo" + domainAttribute + " = " + value);
        return !list.isEmpty();

    }


}
