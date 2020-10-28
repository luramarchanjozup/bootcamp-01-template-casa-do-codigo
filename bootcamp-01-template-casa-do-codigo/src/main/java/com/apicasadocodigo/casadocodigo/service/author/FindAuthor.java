package com.apicasadocodigo.casadocodigo.service.author;

import com.apicasadocodigo.casadocodigo.exception.EntityNotFoundException;
import com.apicasadocodigo.casadocodigo.model.Author;

import javax.persistence.EntityManager;
import java.util.Optional;

public class FindAuthor {

    public static Author byId(Long id, EntityManager manager){


        return Optional.ofNullable(manager.find(Author.class, id))
                .orElseThrow(() -> new EntityNotFoundException(Author.class, id.toString()));
    }

}
