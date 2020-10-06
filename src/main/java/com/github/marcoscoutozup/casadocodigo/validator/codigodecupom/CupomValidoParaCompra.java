package com.github.marcoscoutozup.casadocodigo.validator.codigodecupom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = CupomValidoParaCompraValidator.class)
public @interface CupomValidoParaCompra {

    String message() default "O Cupom não é válido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
