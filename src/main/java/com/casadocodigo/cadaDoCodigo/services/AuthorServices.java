package com.casadocodigo.cadaDoCodigo.services;

import java.util.List;
import java.util.Optional;

import com.casadocodigo.cadaDoCodigo.model.Author;
import com.casadocodigo.cadaDoCodigo.repositories.AuthorRepositiory;
import com.casadocodigo.cadaDoCodigo.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServices {
    
    @Autowired
    private AuthorRepositiory authorRepositiory;

    public Optional<Author> detailedIndex(Long id) {
        Optional<Author> authorObj = authorRepositiory.findById(id);
        return authorObj;
    }

    public List<Author> index() {
        List<Author> authors = authorRepositiory.findAll();
        return authors;
    }

    private String exceptionMsg(Long id) {
        return ("Author of id " + id + " not found");
    }
}
