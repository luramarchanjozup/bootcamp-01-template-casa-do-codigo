package br.com.ecommerce.cdc.anotacao;

import br.com.ecommerce.cdc.validation.CPFouCNPJValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CPFouCNPJValidator.class)
public @interface CPFouCNPJ {

    String message() default "{javax.validation.constraints.CPFouCNPJ.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
