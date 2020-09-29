package com.github.marcoscoutozup.casadocodigo.validator.exists;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = ExistsValidator.class)
public @interface Exists {

    String message() default "O objeto procurado não existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class classe();
}
