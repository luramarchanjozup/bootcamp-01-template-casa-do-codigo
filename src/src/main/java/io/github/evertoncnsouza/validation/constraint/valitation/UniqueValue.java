package io.github.evertoncnsouza.validation.constraint.valitation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented //Mostra que deve ser documentada por javadoc;
@Constraint(validatedBy = UniqueValueValidator.class) //Constraints = restrições. Essa annotation informa a classe de validação;
@Target(ElementType.FIELD) //Mostra que a informação é um campo;
@Retention(RetentionPolicy.RUNTIME) //Mostra que a annotation deve rodar em tempo de runtime.


public @interface UniqueValue {

    String message() default "{dado.ja.cadastrado}";
    //Mensagem de atributo que retorna a chave padrão;

    Class<?>[] groups() default {}; //Grupo de atributos que permite grupos de validação, aos quais a restrição pertense. Default array de tipo vazio;
    Class<? extends Payload>[] payload() default {}; //extends payload para ser usado por classes da API Bean Validation que designa objetos de carga útil a restrição.

    String fieldName(); //Para anotar qual o campo nos atributos;

    Class<?> domainClass(); //Para anotar qual a classe nos atributos;
}
