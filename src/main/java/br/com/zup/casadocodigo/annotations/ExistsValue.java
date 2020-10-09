package br.com.zup.casadocodigo.annotations;

import br.com.zup.casadocodigo.validator.ExistsValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ExistsValueValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface ExistsValue {

    String message() default "{br.com.zup.casadocodigo.annotations.ExistsValue" + "message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String fieldName();
    Class<?> domainClass();
}
