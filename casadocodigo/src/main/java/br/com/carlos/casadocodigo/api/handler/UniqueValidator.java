package br.com.carlos.casadocodigo.api.handler;

import org.modelmapper.internal.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    private String campo;
    private Class<?> aClass;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(Unique params){
        campo = params.fieldName();
        aClass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select 1  from "+aClass.getName()+" where "+campo+"=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.state(list.size() <= 1, "Foi encontrado mais de um "+aClass+" com o atributo "
                +campo+" = "+value);

        return list.isEmpty();
    }

}
