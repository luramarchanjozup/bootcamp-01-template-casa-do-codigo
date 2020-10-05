package br.com.thyagoribeiro.casadocodigo.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

// CDD - Total: 3

public class ContainsValueValidator implements ConstraintValidator<ExistsValue, Object> { // CDD 1 - Interface UniqueValue

    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> domainClass;
    private String fieldName;
    private ValueStatus valueStatus;

    String messageExists = "deve existir na base";
    String messageValueNotExists = "não deve existir na base";

    @Override
    public void initialize(ExistsValue constraintAnnotation) {
        domainClass = constraintAnnotation.domainClass();
        fieldName = constraintAnnotation.fieldName();
        valueStatus = constraintAnnotation.valueStatus();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + domainClass.getSimpleName() + " WHERE " + fieldName + " = :valor");
        query.setParameter("valor", value);

        List<?> result = query.getResultList();
        boolean exists = result.size() > 0;
        context.disableDefaultConstraintViolation();

        if(valueStatus.equals(ValueStatus.NOT_EXISTS)) { // CDD 2 - ENUM ValueStatus e branch if
            context.buildConstraintViolationWithTemplate(messageValueNotExists).addConstraintViolation();
            return !exists;
        }

        context.buildConstraintViolationWithTemplate(messageExists).addConstraintViolation();
        return exists;
    }
}
