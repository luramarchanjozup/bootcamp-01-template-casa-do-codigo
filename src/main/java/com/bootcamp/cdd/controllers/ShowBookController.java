package com.bootcamp.cdd.controllers;

import com.bootcamp.cdd.models.Author;
import com.bootcamp.cdd.models.Book;
import com.bootcamp.cdd.response.BookDetailsResponse;
import com.bootcamp.cdd.response.BookListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/book")
public class ShowBookController {
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> listBooks () {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDetailsResponse getBookById (@PathVariable("id") long id) {
        Book book = entityManager.find(Book.class, id);
        Assert.state(book != null, "O livro com o id "+id+" não foi encontrado");
        Author author = entityManager.find(Author.class, book.getAuthorId());
        Assert.state(author != null, "O autor não foi encontrado");
        return new BookDetailsResponse(book.getTitulo(), book.getResumo(), book.getSumario(), book.getQuantidadePaginas(), book.getPreco(), book.getIsnb(), author.getName(), author.getDescription());
    }
}
