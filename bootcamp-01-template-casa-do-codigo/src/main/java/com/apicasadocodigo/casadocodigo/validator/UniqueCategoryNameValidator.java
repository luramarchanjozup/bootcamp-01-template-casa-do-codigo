package com.apicasadocodigo.casadocodigo.validator;

import com.apicasadocodigo.casadocodigo.model.Category;
import com.apicasadocodigo.casadocodigo.request.CategoryRequest;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UniqueCategoryNameValidator implements Validator {

    @Autowired
    private GenericDAO genericDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoryRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CategoryRequest categoryRequest = (CategoryRequest) object;

        boolean exists = genericDAO
                        .findEntityByAtribute(Category.class, "name", categoryRequest.getName());

        if(!exists){
            errors.reject("categoria", null, "Já existe um(a) outro(a) com a mesma categoria "
            + categoryRequest.getName());
        }
    }
}