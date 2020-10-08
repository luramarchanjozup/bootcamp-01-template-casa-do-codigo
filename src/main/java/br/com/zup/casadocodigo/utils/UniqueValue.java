package br.com.zup.casadocodigo.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;;

@Documented
@Constraint(validatedBy = UniqueValueValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {

    String message() default "duplicate";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    String fieldName();
    Class<?> domainClass();
}
