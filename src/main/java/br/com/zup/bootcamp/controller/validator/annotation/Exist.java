package br.com.zup.bootcamp.controller.validator.annotation;

import br.com.zup.bootcamp.controller.validator.GenericExistenceValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GenericExistenceValidator.class)
public @interface Exist {
    String message() default "br.com.zup.bootcamp.controller.validator.annotation.Exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String fieldName();
    Class<?> domainClass();
}
