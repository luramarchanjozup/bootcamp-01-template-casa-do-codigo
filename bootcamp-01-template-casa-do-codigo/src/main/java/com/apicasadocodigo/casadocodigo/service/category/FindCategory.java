package com.apicasadocodigo.casadocodigo.service.category;

import com.apicasadocodigo.casadocodigo.exception.EntityNotFoundException;
import com.apicasadocodigo.casadocodigo.model.Category;

import javax.persistence.EntityManager;
import java.util.Optional;

public class FindCategory {

    public static Category byId(Long id, EntityManager manager){
//        return Optional.ofNullable(manager.find(Category.class, id))
//                .orElseThrow(() -> new CategoryNotFoundException(id));

        return Optional.ofNullable(manager.find(Category.class, id))
                .orElseThrow(() -> new EntityNotFoundException(Category.class, id.toString()));
    }

}
