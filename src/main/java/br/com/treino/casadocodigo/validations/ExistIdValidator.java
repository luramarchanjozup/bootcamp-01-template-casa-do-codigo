package br.com.treino.casadocodigo.validations;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistIdValidator implements ConstraintValidator<ExistId, Object> {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<?> nomeClasse;
    private String nomeCampo;

    @Override
    public void initialize(ExistId constraintAnnotation) {
        this.nomeClasse = constraintAnnotation.className();
        this.nomeCampo = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if(value == null)
            return true;

        Query query = entityManager.createQuery("select 1 from "+ nomeClasse.getName()+
                " where "+ nomeCampo+"=:value");
        query.setParameter("value", value);

        return !query.getResultList().isEmpty();
    }
}
