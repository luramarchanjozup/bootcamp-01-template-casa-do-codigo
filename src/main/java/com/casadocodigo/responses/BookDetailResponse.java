package com.casadocodigo.responses;

import com.casadocodigo.entity.Book;
import com.casadocodigo.entity.Categories;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookDetailResponse {

    private String title;
    private String summary;
    private String abstractBook;
    private BigDecimal price;
    private int numberOfPages;
    private String isbn;
    private LocalDate publishDate;
    private Categories category;
    private AuthorBookResponse author;

    public BookDetailResponse(Book book) {
        this.title = book.getTitle();
        this.summary = book.getSummary();
        this.abstractBook = book.getAbstractBook();
        this.price = book.getPrice();
        this.numberOfPages = book.getNumberOfPages();
        this.isbn = book.getIsbn();
        this.publishDate = book.getPublishDate();
        this.author = new AuthorBookResponse(book.getAuthor());
        this.category = book.getCategorie();
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getAbstractBook() {
        return abstractBook;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public Categories getCategory() {
        return category;
    }

    public AuthorBookResponse getAuthor() {
        return author;
    }
}
