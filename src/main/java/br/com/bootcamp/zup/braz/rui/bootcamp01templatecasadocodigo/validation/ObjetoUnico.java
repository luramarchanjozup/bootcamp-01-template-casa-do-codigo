package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ObjetoUnicoValidador.class)
public @interface ObjetoUnico {

    String message() default "Já cadastrado no banco.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}
