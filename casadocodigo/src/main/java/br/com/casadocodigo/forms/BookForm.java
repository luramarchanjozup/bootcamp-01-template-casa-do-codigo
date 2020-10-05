package br.com.casadocodigo.forms;
import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.validation.Unique;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;


public class BookForm {

    @NotBlank
    @Unique(fieldName = "title", domainClass = Book.class)
    private String title;

    @NotBlank
    private String resume;

    @NotBlank
    private String summary;

    @NotBlank
    @Min(20)
    private Double price;

    @NotBlank
    @Min(100)
    private Long pages;

    @NotBlank
    @Unique(fieldName = "isbn", domainClass = Book.class)
    private Long Isbn;

    @Future
    private OffsetDateTime publishedAt;

    public Book toEntity(){

        return new Book(title,resume,summary,price,pages,Isbn, publishedAt);

    }

    @Deprecated
    public BookForm(){};

    public BookForm(String title, String resume, String summary, Double price, Long pages, Long isbn, OffsetDateTime publishedAt) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.pages = pages;
        Isbn = isbn;
        this.publishedAt = publishedAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public void setIsbn(Long isbn) {
        Isbn = isbn;
    }
}
