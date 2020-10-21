package br.com.itau.casadocodigo.validador;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//Criando a anotação de validação
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CPFouCNPJValidator.class) //Precisamos dizer que a nossa anotação é uma Constraint
public @interface CPFouCNPJ {

    //    Texto deve ser genérico para o retorno da informação
    String message() default "inválido. Padrão: XXX.XXX.XXX-XX ou XX.XXX.XXX/XXXX-XX";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
