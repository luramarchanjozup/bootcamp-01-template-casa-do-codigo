package br.com.casacodig.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {ValidadorCupom.class})
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.PARAMETER, ElementType.FIELD })
public @interface CupomValido {

	String message() default "Cupom Invalido";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	
	String campo();
	
}
