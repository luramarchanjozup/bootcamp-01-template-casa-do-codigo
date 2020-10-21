package br.com.itau.casadocodigo.validador;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class VerificaEstadoPaisValidator implements ConstraintValidator<VerificaEstadoPais, String> {

    private String atributoDoDominio;
    private Class<?> classeDoDominio;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(VerificaEstadoPais constraintAnnotation) {
        this.atributoDoDominio = constraintAnnotation.nomeDoAtributo();
        this.classeDoDominio = constraintAnnotation.classeDeDominio();
    }

    @Override
    public boolean isValid(String valor, ConstraintValidatorContext context) {
        Query query = this.entityManager.createQuery("SELECT 1 FROM " + this.classeDoDominio.getName() + " WHERE " + this.atributoDoDominio + " =:VALUE");
        query.setParameter("VALUE", valor);

        List<?> list = query.getResultList();
        return !list.isEmpty();
    }
}
