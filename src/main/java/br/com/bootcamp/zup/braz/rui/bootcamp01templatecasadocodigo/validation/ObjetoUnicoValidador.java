package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.annotation.ObjetoUnico;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ObjetoUnicoValidador implements ConstraintValidator<ObjetoUnico, String> {

    private String campo;
    private Class<?> classe;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void initialize(ObjetoUnico objetoUnico) {
        campo = objetoUnico.fieldName();
        classe = objetoUnico.domainClass();
    }

    @Override
    public boolean isValid(String valor, ConstraintValidatorContext constraintValidatorContext) {
        Query customQuery = entityManager.createQuery("select 1 from " + classe.getName() + " where " + campo + " = :valor");
        customQuery.setParameter("valor", valor);
        List<?> resultadoConsulta = customQuery.getResultList();
        Assert.state(resultadoConsulta.size() <=1, "Foi encontrado mais de um "+classe+" com o atributo "+campo+" = "+valor);

        return resultadoConsulta.isEmpty();
    }
}
