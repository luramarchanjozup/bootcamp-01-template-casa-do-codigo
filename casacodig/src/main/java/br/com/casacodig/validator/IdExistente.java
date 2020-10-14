package br.com.casacodig.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//Sinaliza para o JAVADOC que a sua anotação deve ficar visivel
@Documented
//Marca a anotação como uma Constraint e especifica qual o validador que vai ser utilizado para validar a anotaçào 
@Constraint(validatedBy = {ValidadorIdExistente.class})
//Sinaliza para o compilador que a anotação deve ficar disponivel durante o RUNTIME
@Retention(RetentionPolicy.RUNTIME)
//Especifica quais os tipos de elementos a anotação pode ser utilizada para marcar
//Field declaration (includes enum constants)
//@Target(ElementType.FIELD)
@Target( { ElementType.PARAMETER, ElementType.FIELD })
public @interface IdExistente {

	String message() default "Falha por estar não exister o ID informado";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	
	//Variaveis que são passadas no momento do uso da anotaçào customizada
	String campo();
	String classe();
	
}
