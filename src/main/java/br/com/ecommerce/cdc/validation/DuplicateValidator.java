package br.com.ecommerce.cdc.validation;

import br.com.ecommerce.cdc.anotacao.NotDuplicated;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Carga intrinseca máxima permitida - 7
 * Carga intrinseca da classe - 2
 */

public class DuplicateValidator implements ConstraintValidator<NotDuplicated, String > {

    private String nameClass;
    private String fieldName;

    private final EntityManager manager;

    public DuplicateValidator(EntityManager entityManager){
        this.manager=entityManager;
    }

    @Override
    // +1
    public void initialize(NotDuplicated constraintAnnotation) {
        this.nameClass = constraintAnnotation.nameClass();
        this.fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        Query query = manager.createQuery("select c from " + nameClass + " c where  c." + fieldName + "  =:value");
        // +1
        List<?> resultList = query.setParameter("value", value).getResultList();

        if (resultList.size()==0){
            return true;
        }

        return false;
    }
}
