package com.apicasadocodigo.casadocodigo.service.validator;

import com.apicasadocodigo.casadocodigo.model.Category;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Component
public class ValideUniqueCategory implements Validator {

   // @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return  Category.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        if(errors.hasErrors()){
            return ;
        }

        Category category = (Category) o;

        Query query =  manager.createNativeQuery("SELECT c.name FROM category as c " +
                                                    "WHERE c.name = :name " +
                                                    "LIMIT 1;");

        query.setParameter("name", category.getName());

        boolean exists =  query.getResultList().contains(category.getName());

        if (exists) {

            String massage = String.format("The %s category already exists. Please, input another category.",
                    category.getName());

            errors.reject("name", null, massage);

        }

    }
}
