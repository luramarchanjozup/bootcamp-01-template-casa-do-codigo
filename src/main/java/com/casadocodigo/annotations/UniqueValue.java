package com.casadocodigo.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.casadocodigo.validators.UniqueValueValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
public @interface UniqueValue {

  String message() default "{com.casadocodigo.beanvalidation.uniquevalue" + "message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String fieldName();

  Class<?> domainClass();

}
