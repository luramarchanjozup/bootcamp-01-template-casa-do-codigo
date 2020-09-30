package com.casadocodigo.casaDoCodigo.controllers.dto;

import java.time.LocalDate;

import com.casadocodigo.casaDoCodigo.model.Book;
import com.casadocodigo.casaDoCodigo.model.Category;

public class DetailedBookDto {
    private Long id;
    private String title;
    private String resume;
    private String summary;
    private float price;
    private Integer totalPages;
    private LocalDate publicationDate;
    private Category category;
    private DetailedAuthorDto author;

    public DetailedBookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.resume = book.getResume();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.totalPages = book.getTotalPages();
        this.publicationDate = book.getPublicationDate();
        this.category = book.getCategory();
        this.author = new DetailedAuthorDto(book.getAuthor());
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getResume() {
        return this.resume;
    }

    public String getSummary() {
        return this.summary;
    }

    public float getPrice() {
        return this.price;
    }

    public Integer getTotalPages() {
        return this.totalPages;
    }

    public LocalDate getPublicationDate() {
        return this.publicationDate;
    }

    public Category getCategory() {
        return this.category;
    }

    public DetailedAuthorDto getAuthor() {
        return this.author;
    }

}
