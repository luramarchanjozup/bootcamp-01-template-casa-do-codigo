package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.annotation.ObjetoValido;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ObjetoValidoValidator implements ConstraintValidator<ObjetoValido, Integer> {

    private String campo;
    private Class<?> classe;

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void initialize(ObjetoValido objetoValido) {
        campo = objetoValido.fieldName();
        classe = objetoValido.domainsClass();

    }

    @Override
    public boolean isValid(Integer idAtributo, ConstraintValidatorContext constraintValidatorContext) {
        Query customQuery = entityManager.createQuery("select 1 from " + classe.getName() + " where " + campo + " =: idAtributo");
        customQuery.setParameter("idAtributo", idAtributo);

        List<?> list = customQuery.getResultList();
        Assert.isTrue(list.size() <= 1, "Nenhum registro encontrado com id: " + campo + " na tabela: " + classe.getName().toUpperCase());
        return !list.isEmpty();
    }
}
