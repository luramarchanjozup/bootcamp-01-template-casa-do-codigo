package com.casadocodigo.cadaDoCodigo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.casadocodigo.cadaDoCodigo.controllers.form.AuthorForm;
import com.casadocodigo.cadaDoCodigo.model.Author;
import com.casadocodigo.cadaDoCodigo.repositories.AuthorRepositiory;

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
    
    @Transactional
    public Author createAuthor(AuthorForm form) {
        Author author = new Author(form.getName(), form.getEmail(), form.getDescription());
        authorRepositiory.save(author);

        return author;
    }
}
