package com.casadocodigo.casaDoCodigo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.casadocodigo.casaDoCodigo.controllers.dto.BookDto;
import com.casadocodigo.casaDoCodigo.controllers.dto.DetailedBookDto;
import com.casadocodigo.casaDoCodigo.controllers.form.BookForm;
import com.casadocodigo.casaDoCodigo.model.Author;
import com.casadocodigo.casaDoCodigo.model.Book;
import com.casadocodigo.casaDoCodigo.model.Category;
import com.casadocodigo.casaDoCodigo.repositories.AuthorRepository;
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
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public DetailedBookDto createBook(BookForm form) {
        Optional<Author> author = authorRepository.findByName(form.getAuthor());
        Optional<Category> category = categoryRepository.findByName(form.getCategory());

        Book book = new Book(form.getTitle(), form.getResume(), form.getSummary(), form.getPrice(), form.getTotalPages(), 
                            form.getIsbn(), form.getPublicationDate(), 
                            category.orElseThrow(() -> new ObjectNotFoundException(exceptionMsg(form.getCategory(), "Category"))), 
                            author.orElseThrow(() -> new ObjectNotFoundException(exceptionMsg(form.getAuthor(), "Author"))));
        bookRepository.save(book);
        
        return new DetailedBookDto(book);
    }

    public DetailedBookDto detailedIndex(Long id) {
        Optional<Book> bookObj = bookRepository.findById(id);
        return new DetailedBookDto(bookObj.orElseThrow(() -> new ObjectNotFoundException("No book with id " + id + "found.")));
    }

    public List<BookDto> index() {
        List<Book> books = bookRepository.findAll();
        return BookDto.convert(books);
    }

    private String exceptionMsg(String name, String element) {
        return ("There's no " + element + name + " registered. Cannot register Book.\n" +
                "Make sure that the " + element + "'s name is correct");
    }
}
