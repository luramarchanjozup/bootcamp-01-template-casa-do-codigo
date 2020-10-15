package br.com.zup.casadocodigo.validacao;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {UnicoValidador.class})
@Target({FIELD})
@Retention(RUNTIME)

public @interface ValorUnico {

	String message() default "{br.com.zup.casadocodigo.beanvalidation.unicovalor}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default{};
	
	String nomeCampo();
	
	Class <?> classeDominio();

}
