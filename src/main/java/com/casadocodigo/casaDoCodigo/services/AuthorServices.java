package com.casadocodigo.casaDoCodigo.services;

import javax.transaction.Transactional;

import com.casadocodigo.casaDoCodigo.controllers.dto.DetailedAuthorDto;
import com.casadocodigo.casaDoCodigo.controllers.form.AuthorForm;
import com.casadocodigo.casaDoCodigo.model.Author;
import com.casadocodigo.casaDoCodigo.repositories.AuthorRepository;
import com.casadocodigo.casaDoCodigo.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServices {
    
    @Autowired
    private AuthorRepository authorRepository;

    public DetailedAuthorDto detailedIndex(String email) {
        return new DetailedAuthorDto(authorRepository.findByEmail(email).orElseThrow(
                            () -> new ObjectNotFoundException(exceptionMsg(email))));
    }
    
    @Transactional
    public DetailedAuthorDto createAuthor(AuthorForm form) {
        Author author = new Author(form.getName(), form.getEmail(), form.getDescription());
        authorRepository.save(author);

        return new DetailedAuthorDto(author);
    }

    private String exceptionMsg(String email) {
        return ("Author with email " + email + " not found.");
    }
}
