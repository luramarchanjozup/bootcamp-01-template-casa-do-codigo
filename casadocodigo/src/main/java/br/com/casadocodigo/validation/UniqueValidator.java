package br.com.casadocodigo.validation;
import br.com.casadocodigo.models.Author;
import br.com.casadocodigo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    @PersistenceContext
    private EntityManager entityManager;

    // +1
    private String domainAttribute;

    // +1
    private Class<?> klass;

    @Override
    public void initialize(Unique constraintAnnotation) {

        // +1
        domainAttribute = constraintAnnotation.fieldName();

        // +1
        klass = constraintAnnotation.domainClass();

    }

    @Override                            // +1
    public boolean isValid(Object fieldContentToBeValidated, ConstraintValidatorContext constraintValidatorContext) {

        // +1
        return entityManager
                .createQuery("select 1 from " + klass.getName() + " where "+ domainAttribute + "=:value")
                .setParameter("value", fieldContentToBeValidated)
                .getResultList()
                .isEmpty();

    }
}
