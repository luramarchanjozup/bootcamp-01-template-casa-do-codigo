package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.services.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EmailDuplicadoValidator.class)
public @interface EmailDuplicado {

    String message() default "Já existe um usuário para esse email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
