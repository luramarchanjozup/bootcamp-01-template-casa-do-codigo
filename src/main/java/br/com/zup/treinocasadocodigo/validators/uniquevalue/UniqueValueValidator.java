package br.com.zup.treinocasadocodigo.validators.uniquevalue;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Contagem de carga intrínseca da classe: 2
 */

//1
public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

    private String nomeCampo;
    Class<?> dominioClasse;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        nomeCampo = constraintAnnotation.nomeCampo();
        dominioClasse = constraintAnnotation.dominioClasse();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        //1
        if (value == null) {
            return true;
        }

        List<?> list = manager
                .createQuery("select 1 from "+dominioClasse.getName()+" where "+nomeCampo+"=:value")
                .setParameter("value", value)
                .getResultList();

        Assert.state(list.size() <=1, "Foi encontrado mais de um "+dominioClasse+" com o atributo "+nomeCampo+" = "+value);

        return list.isEmpty();
    }
}
