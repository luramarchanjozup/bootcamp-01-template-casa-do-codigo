package br.com.zup.bootcamp.controller.validator;

import br.com.zup.bootcamp.controller.validator.annotation.Unique;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;

// Intrinsic charge = 2
public class GenericUnityValidator implements ConstraintValidator<Unique, Object> {

    @PersistenceContext
    private EntityManager manager;

    private String fieldName;
    private Class<?> domainClass;

    @Override
    public void initialize(Unique params) {
        this.fieldName = params.fieldName();
        this.domainClass = params.domainClass();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        if(obj == null){
            return true;
        }
        Query query = manager.createQuery(
                "select " + fieldName + " from " + domainClass.getName() + " where " + this.fieldName + " = :value"
        );
        query.setParameter("value", obj);
        Collection<?> result = query.getResultList();

        return result.isEmpty();
    }
}
