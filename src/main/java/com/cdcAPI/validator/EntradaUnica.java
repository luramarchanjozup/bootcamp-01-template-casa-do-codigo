package com.cdcAPI.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidarEntradaUnica.class)
public @interface EntradaUnica {

    String message() default "Esse valor já foi utilizado. Tente outro.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName(); //Valor duplicado

    Class<?> domainClass(); //Classe onde está a duplicação

}
