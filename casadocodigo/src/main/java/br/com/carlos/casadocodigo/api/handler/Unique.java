package br.com.carlos.casadocodigo.api.handler;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Constraint(validatedBy = {UniqueValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface Unique {

    String message() default "duplicado";
    Class<? extends Payload>[] payload() default { };
    Class<?>[] groups() default { };

    String fieldName();
    Class<?> domainClass();
}
