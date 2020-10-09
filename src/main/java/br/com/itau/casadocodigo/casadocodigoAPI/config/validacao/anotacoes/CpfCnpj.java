package br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.CpfCnpjValidator;

@Documented
@Constraint(validatedBy = { CpfCnpjValidator.class })
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfCnpj {

	String message() default "CPF ou CNPJ são inválidos!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
