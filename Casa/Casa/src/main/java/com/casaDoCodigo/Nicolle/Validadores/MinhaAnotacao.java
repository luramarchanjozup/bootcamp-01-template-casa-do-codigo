package com.casaDoCodigo.Nicolle.Validadores;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MeuValidador.class)
public @interface MinhaAnotacao {

  String message() default "Valores já cadastrados (Autor, Categoria, Email, etc), verifique as informações e tente novamente!";;

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
  String nomeCampo();
  Class<?> dominioClasse();
}