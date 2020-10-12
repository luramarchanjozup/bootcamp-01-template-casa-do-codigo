package dev.arielalvesdutrazup.cdc.annotations;

import dev.arielalvesdutrazup.cdc.annotations.validators.DocumentoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;

@Documented
@Constraint(validatedBy = DocumentoValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ FIELD })
public @interface Documento {
    String message() default "Documento inválido!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
