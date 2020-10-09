package br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.QuantidadeLivrosValidator;

@Documented
@Constraint(validatedBy = { QuantidadeLivrosValidator.class })
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface QuantidadeLivros {

	String message() default "{O número de livros informados deve ser igual a quantidade presente no carrinho!}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
