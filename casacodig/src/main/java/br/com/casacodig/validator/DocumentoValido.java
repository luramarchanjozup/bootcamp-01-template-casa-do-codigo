package br.com.casacodig.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {ValidadorDocumento.class})
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.PARAMETER, ElementType.FIELD })
public @interface DocumentoValido {

	String message() default "CNPJ ou CPF Invalido";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	
	String campo();
}
