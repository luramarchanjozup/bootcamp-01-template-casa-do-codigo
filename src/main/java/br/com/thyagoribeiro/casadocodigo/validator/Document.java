package br.com.thyagoribeiro.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

// CDD - Total: 2

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {DocumentValidator.class}) // CDD 1 - Classe DocumentValidator
public @interface Document {

    String message() default "não está num formato correto";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    DocumentType[] documentTypes(); // CDD 1 - ENUM DocumentType

}
