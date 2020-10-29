package bootcamp.challenges.casadocodigo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Total Intrinsic Load Points: 1
@Constraint(validatedBy = EntityValueExistsValidator.class) // 1 - EntityUniqueValueValidator
@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityValueExists {
    String message() default "{bootcamp.challenges.casadocodigo.validator.EntityValueExists}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<?> entityClass();
    String entityFieldName();
    boolean expectedAssertion() default false;
}
