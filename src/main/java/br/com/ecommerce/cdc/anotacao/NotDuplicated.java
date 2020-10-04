package br.com.ecommerce.cdc.anotacao;

import br.com.ecommerce.cdc.validation.DuplicateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = DuplicateValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD,ElementType.LOCAL_VARIABLE})
public @interface NotDuplicated {

    String message() default "{javax.validation.constraints.NotBlank.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String fieldName();

    String nameClass();

}
