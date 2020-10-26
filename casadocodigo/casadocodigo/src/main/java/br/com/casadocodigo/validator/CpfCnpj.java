package br.com.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ValidadorCpfCnpj.class})
public @interface CpfCnpj {

    String message() default "Deve ser um documento válido";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
