package br.com.itau.casadocodigo.validador;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//Criando a anotação de validação
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = VerificaEstadoPaisValidator.class) //Precisamos dizer que a nossa anotação é uma Constraint
public @interface VerificaEstadoPais {

    //    Texto deve ser genérico para o retorno da informação
    String message() default "não corresponde ao país.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String nomeDoAtributo();
    Class<?> classeDeDominio();

}
