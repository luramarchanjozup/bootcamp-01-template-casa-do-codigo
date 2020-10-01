package br.com.casacodig.validator;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;

//Sinaliza para o JAVADOC que a sua anotação deve ficar visivel
@Documented
//Marca a anotação como uma Constraint e especifica qual o validador que vai ser utilizado para validar a anotaçào 
@Constraint(validatedBy = {ValidadorValorUnico.class})
//Sinaliza para o compilador que a anotação deve ficar disponivel durante o RUNTIME
@Retention(RetentionPolicy.RUNTIME)
//Especifica quais os tipos de elementos a anotação pode ser utilizada para marcar
//Field declaration (includes enum constants)
@Target(ElementType.FIELD)

public @interface ValorUnico {

	String message() default "{com.deveficiente.beanvalidation.uniquevalue}";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	
	//Variaveis que são passadas no momento do uso da anotaçào customizada
	String campo();
	Class<?> classe();
	
}
