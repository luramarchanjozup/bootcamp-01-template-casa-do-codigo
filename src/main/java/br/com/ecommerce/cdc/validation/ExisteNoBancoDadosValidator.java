package br.com.ecommerce.cdc.validation;

import br.com.ecommerce.cdc.anotacao.ExistInDataBase;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExisteNoBancoDadosValidator implements ConstraintValidator<ExistInDataBase,Long> {

    private Class<?> nameClass;
    private String teste;

    @Autowired
    private EntityManager manager;

    @Override
    public void initialize(ExistInDataBase constraintAnnotation) {
        this.nameClass = constraintAnnotation.nameFieldClass();
        this.teste=constraintAnnotation.nameClass();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Object o = manager.find(nameClass, value);

/*
        // Outra forma de procurar no banco sem JpaRepository
        Query query = manager.createQuery("select c from "+ teste +" c where id =:value");
        query.setParameter("value",value);
        List<?> resultList = query.getResultList();
*/

        if (o == null ){
            return false;
        }

        return true;
    }
}
