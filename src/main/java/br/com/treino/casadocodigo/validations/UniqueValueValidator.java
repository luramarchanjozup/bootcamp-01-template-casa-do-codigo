package br.com.treino.casadocodigo.validations;

import br.com.treino.casadocodigo.errors.Resultado;
import org.springframework.util.Assert;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private Class<?> nomeClass;
    private String nomeCampo;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        nomeClass = constraintAnnotation.className();
        nomeCampo = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Query query = entityManager.createQuery("select 1 from "+ nomeClass.getName()+
                " where "+ nomeCampo+"=:value");
        query.setParameter("value", value);

        //List<?> list = query.getResultList();
        //if (list.size()>=1)
            //Resultado.erro(new IllegalStateException("Foi encontrado mais de um "
            //        +nomeClass+" com o atributo "+nomeCampo+" = " + value));
             //throw new IllegalStateException("Foi encontrado mais de um "
             //       +nomeClass+" com o atributo "+nomeCampo+" = " + value);
            //Assert.state(list.size() <=1, "Foi encontrado mais de um "
            //    +nomeClass+" com o atributo "+nomeCampo+" = " + value);

        //return list.isEmpty();
        return query.getResultList().isEmpty();
    }
}
