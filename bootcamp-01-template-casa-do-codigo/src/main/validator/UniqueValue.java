package com.apicasadocodigo.casadocodigo.service.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER} )
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UniqueValueConstrainte.class)
public @interface UniqueValue {

    String message() default "Descreva a mensagem do erro aqui!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class <?> entity();

    String attributeName();

}
