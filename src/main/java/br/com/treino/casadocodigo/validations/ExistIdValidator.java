package br.com.treino.casadocodigo.validations;

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

        Query query = entityManager.createQuery("select 1 from "+ nomeClasse.getName()+
                " where "+ nomeCampo+"=:value");
        query.setParameter("value", value);

        List<?> lista = query.getResultList();

        if(lista.isEmpty())
        {
            System.out.println("Lista vazia \n"+lista.size());
            return false;
        }else{
            System.out.println("Lista com items \n"+lista.size());
            return true;
        }

    }
}
