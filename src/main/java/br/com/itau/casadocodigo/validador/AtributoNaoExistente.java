package br.com.itau.casadocodigo.validador;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//Criando a anotação de validação
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AtributoNaoExistenteValidator.class) //Precisamos dizer que a nossa anotação é uma Constraint
public @interface AtributoNaoExistente {

//    Texto deve ser genérico para o retorno da informação
    String message() default "não existe no banco";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

//    Criando parâmetros (nomeDoAtributo e classeDeDominio) para receber através da anotação
//    nomeDoAtributo: receber o nome do atributo email ou nomeCategoria
    String nomeDoAtributo();

//    classeDeDominio: receber o nome do domínio da classe: Autor ou Categoria
    Class<?> classeDeDominio();
}
