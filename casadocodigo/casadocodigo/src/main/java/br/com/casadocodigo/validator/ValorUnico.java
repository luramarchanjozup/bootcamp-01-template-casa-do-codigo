package br.com.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidadorValorUnico.class)
public @interface ValorUnico {

    String message() default "O valor deve ser único";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};
    String fieldName();
    Class<?> domainClass();




}
