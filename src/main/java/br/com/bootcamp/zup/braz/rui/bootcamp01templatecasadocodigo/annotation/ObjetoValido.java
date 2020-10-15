package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.annotation;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation.ObjetoValidoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ObjetoValidoValidator.class)
public @interface ObjetoValido {
    String message() default "não existe no banco.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}
