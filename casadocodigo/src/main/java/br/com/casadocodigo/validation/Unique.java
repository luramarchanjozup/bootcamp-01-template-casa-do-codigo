package br.com.casadocodigo.validation;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Documented
@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = { UniqueValidator.class })
public @interface Unique {

    String message() default "the attribute must be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
