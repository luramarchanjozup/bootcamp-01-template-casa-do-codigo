package br.com.treino.casadocodigo.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CpfOuCnpjValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfOuCnpj {

    String message() default "{br.com.treino.casadocodigo.CpfOuCnpj}";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
