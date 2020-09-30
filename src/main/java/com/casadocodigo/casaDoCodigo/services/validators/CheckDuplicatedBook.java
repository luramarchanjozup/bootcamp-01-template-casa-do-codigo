package com.casadocodigo.casaDoCodigo.services.validators;

import java.util.Optional;

import com.casadocodigo.casaDoCodigo.controllers.form.BookForm;
import com.casadocodigo.casaDoCodigo.model.Book;
import com.casadocodigo.casaDoCodigo.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CheckDuplicatedBook implements Validator {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return BookForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) return;

        BookForm request = (BookForm) target;

        Optional<Book> possibleBookTitle = bookRepository.findByTitle(request.getTitle());
        Optional<Book> possibleBookIsbn = bookRepository.findByIsbn(request.getIsbn());

        if(possibleBookTitle.isPresent() || possibleBookIsbn.isPresent()) {
            if(possibleBookTitle.isPresent()) {
                errors.rejectValue("title", null, "There's already a registered book with the title " + request.getTitle() + ".");
            } else {
                errors.rejectValue("isbn", null, "There's already a registered book with the isbn " + request.getIsbn() + ".");
            }
        }

    }
    
}
