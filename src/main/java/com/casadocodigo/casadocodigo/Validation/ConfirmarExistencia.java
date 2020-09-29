package com.casadocodigo.casadocodigo.Validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ConfirmarExistenciaValidador.class)
public @interface ConfirmarExistencia {

String message() default "Já temos esse valor cadastrado, por favor insira um novo valor";

Class<?>[] groups() default {};

Class<? extends Payload>[] payload() default {};

Class<?> classe();

String campo();
 

}
