package br.com.ecommerce.cdc.anotacao;

import br.com.ecommerce.cdc.validation.ExisteNoBancoDadosValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExisteNoBancoDadosValidator.class)
public @interface ExistInDataBase {

    String message() default "não encontrado no banco de dados!!!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?> nameFieldClass();

    String nameClass();

}
