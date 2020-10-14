package br.com.thyagoribeiro.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

// CDD - Total: 1

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {CupomValidator.class}) // CDD 1 - Classe CupomValidator
public @interface CupomValido {

    String message() default "";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
