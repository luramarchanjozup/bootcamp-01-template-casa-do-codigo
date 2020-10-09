package com.casadocodigo.casaDoCodigo.controllers.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.casadocodigo.casaDoCodigo.model.Book;
import com.casadocodigo.casaDoCodigo.model.Category;

public class BookDto {
    private Long id;
    private String title;
    private Float price;
    private Category category;
    private AuthorDto author;

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.price = book.getPrice();
        this.category = book.getCategory();
        this.author = new AuthorDto(book.getAuthor());
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Float getPrice() {
        return this.price;
    }

    public Category getCategory() {
        return this.category;
    }

    public AuthorDto getAuthor() {
        return this.author;
    }

    public static List<BookDto> convert(List<Book> books) {
        return books.stream().map(BookDto::new).collect(Collectors.toList());
    }
}
