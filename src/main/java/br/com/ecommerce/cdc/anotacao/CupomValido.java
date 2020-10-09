package br.com.ecommerce.cdc.anotacao;

import br.com.ecommerce.cdc.validation.CupomValidoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CupomValidoValidator.class)
public @interface CupomValido {

    String message() default "{javax.validation.constraints.CupomValido.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
