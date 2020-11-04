package bootcamp.challenges.casadocodigo.validators;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// Total Intrinsic Load Points: 1
public class EntityValueExistsValidator implements ConstraintValidator<EntityValueExists, Object> { // 1 - EntityUniqueValue

    private String entityName;
    private String entityFieldName;
    private boolean expectedAssertion;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void initialize(EntityValueExists entityUniqueValue) {
        entityName = entityUniqueValue.entityClass().getSimpleName();
        entityFieldName = entityUniqueValue.entityFieldName();
        expectedAssertion = entityUniqueValue.expectedAssertion();
    }
    @Transactional
    @Override
    public boolean isValid(Object fieldValue, ConstraintValidatorContext constraintValidatorContext) {
        boolean exists = !entityManager.createQuery("SELECT 1 FROM "+entityName+" WHERE "+entityFieldName+"=:value")
                .setParameter("value", fieldValue)
                .getResultList()
                .isEmpty();
        return exists == expectedAssertion;
    }
}
