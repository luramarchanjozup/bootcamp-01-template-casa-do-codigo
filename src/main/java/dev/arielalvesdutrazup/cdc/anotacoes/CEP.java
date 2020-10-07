package dev.arielalvesdutrazup.cdc.anotacoes;

import dev.arielalvesdutrazup.cdc.anotacoes.validators.CEPValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Documented
@Constraint(validatedBy = CEPValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ FIELD })
public @interface CEP {
    String message() default "CEP deve ter um formato válido!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
