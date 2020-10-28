package com.apicasadocodigo.casadocodigo.service.country;

import com.apicasadocodigo.casadocodigo.exception.EntityNotFoundException;
import com.apicasadocodigo.casadocodigo.model.Author;
import com.apicasadocodigo.casadocodigo.model.Country;

import javax.persistence.EntityManager;
import java.util.Optional;

public class FindCountry {

    public static Country byId(Long id, EntityManager manager){
//         return Optional.ofNullable(manager.find(Author.class, id))
//                 .orElseThrow(() -> new AuthorNotFoundException(id));

        return Optional.ofNullable(manager.find(Country.class, id))
                .orElseThrow(() -> new EntityNotFoundException(Author.class, id.toString()));
    }

}
