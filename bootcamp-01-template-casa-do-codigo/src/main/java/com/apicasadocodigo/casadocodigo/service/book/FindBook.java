package com.apicasadocodigo.casadocodigo.service.book;

import com.apicasadocodigo.casadocodigo.exception.EntityNotFoundException;
import com.apicasadocodigo.casadocodigo.model.Book;

import javax.persistence.EntityManager;
import java.util.Optional;

public class FindBook {

    public static Book byId(Long id, EntityManager manager){
//         return Optional.ofNullable(manager.find(Book.class, id))
//                 .orElseThrow(() -> new BookNotFoundException(id));

        return Optional.ofNullable(manager.find(Book.class, id))
                .orElseThrow(() -> new EntityNotFoundException(Book.class, id.toString()));
    }

}
