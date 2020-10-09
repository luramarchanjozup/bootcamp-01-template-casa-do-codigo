package br.com.zup.bootcamp.controller.validator;

import br.com.zup.bootcamp.controller.validator.annotation.Exist;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;

// Intrinsic charge = 2
public class GenericExistenceValidator implements ConstraintValidator<Exist, Object> {

    @PersistenceContext
    private EntityManager manager;

    private String fieldName;
    private Class<?> domainClass;

    @Override
    public void initialize(Exist params) {
        this.fieldName = params.fieldName();
        this.domainClass = params.domainClass();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        if(obj == null){
            return true;
        }
        Query query = manager.createQuery(
                "select "+ fieldName + " from " + domainClass.getName() + " where " + fieldName + " = :value"
        );
        query.setParameter("value", obj);

        Collection<?> result = query.getResultList();
        return !result.isEmpty();
    }
}
