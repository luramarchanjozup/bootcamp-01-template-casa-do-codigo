package com.casadocodigo.casaDoCodigo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.casadocodigo.casaDoCodigo.controllers.form.BookForm;
import com.casadocodigo.casaDoCodigo.model.Author;
import com.casadocodigo.casaDoCodigo.model.Book;
import com.casadocodigo.casaDoCodigo.model.Category;
import com.casadocodigo.casaDoCodigo.repositories.AuthorRepositiory;
import com.casadocodigo.casaDoCodigo.repositories.BookRepository;
import com.casadocodigo.casaDoCodigo.repositories.CategoryRepository;
import com.casadocodigo.casaDoCodigo.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServices {
    
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepositiory authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public Book createBook(BookForm form) {
        Optional<Author> author = authorRepository.findByName(form.getAuthor());
        Optional<Category> category = categoryRepository.findByName(form.getCategory());

        Book book = new Book(form.getTitle(), form.getResume(), form.getSummary(), form.getPrice(), form.getTotalPages(), 
                            form.getIsbn(), form.getPublicationDate(), 
                            category.orElseThrow(() -> new ObjectNotFoundException(exceptionMsg(form.getCategory(), "Category"))), 
                            author.orElseThrow(() -> new ObjectNotFoundException(exceptionMsg(form.getAuthor(), "Author"))));
        bookRepository.save(book);
        
        return book;
    }

    private String exceptionMsg(String name, String element) {
        return ("There's no " + element + name + " registered. Cannot register Book.\n" +
                "Make sure that the " + element + "'s name is correct");
    }
}
