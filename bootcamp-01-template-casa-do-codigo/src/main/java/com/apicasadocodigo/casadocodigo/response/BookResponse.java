package com.apicasadocodigo.casadocodigo.response;

import com.apicasadocodigo.casadocodigo.model.Book;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BookResponse implements Serializable {

    private Long id;
    private String title;
    private BigDecimal price;
    private String summary;
    private String chapeters;
    private AuthorResponse author;
    private DataBook dataBook;

    private BookResponse(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
        this.price = book.getPrice();
        this.summary = book.getSummary();
        this.chapeters = book.getChapeters();
        this.author = new AuthorResponse(book.getAuthor());
        this.dataBook = new DataBook(book.getPageQuantity(), book.getIsbn());
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AuthorResponse getAuthor() {
        return author;
    }

    public DataBook getDataBook() {
        return dataBook;
    }

    @JsonIgnore
    public static BookResponse fromModel(Object o){
        return new BookResponse((Book) o);
    }

}
