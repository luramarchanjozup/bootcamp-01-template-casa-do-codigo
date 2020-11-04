package bootcamp.challenges.casadocodigo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CpfCnpjValidator.class) // 1 - EntityUniqueValueValidator
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfCnpj {
    String message() default "{bootcamp.challenges.casadocodigo.validator.CpfCnpj}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
