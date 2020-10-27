package com.casaDoCodigo.Nicolle.Validadores;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {CPFCNPJValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CPFCNPJ {
	
	String message() default "É necessário um número de documento válido!";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default{};
	

	
}
