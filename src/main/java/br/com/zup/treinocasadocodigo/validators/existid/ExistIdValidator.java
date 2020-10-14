package br.com.zup.treinocasadocodigo.validators.existid;

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
public class ExistIdValidator implements ConstraintValidator<ExistId, Long> {
    private String nomeCampo;
    Class<?> dominioClasse;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistId constraintAnnotation) {
        nomeCampo = constraintAnnotation.nomeCampo();
        dominioClasse = constraintAnnotation.dominioClasse();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        //1
        if (value == null) {
            return true;
        }

        List<?> list = manager
                .createQuery("select 1 from "+dominioClasse.getName()+" where "+nomeCampo+"=:value")
                .setParameter("value", value)
                .getResultList();

        return !list.isEmpty();
    }
}
