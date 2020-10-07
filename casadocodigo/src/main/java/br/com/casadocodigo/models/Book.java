package br.com.casadocodigo.models;

import br.com.casadocodigo.validation.ExistsId;
import br.com.casadocodigo.validation.Unique;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.OffsetDateTime;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    @Max(500)
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
    private Long isbn;

    @Future
    private OffsetDateTime publishedAt;

    @ManyToOne
    @NotNull
    @Valid
    private Category category;

    @ManyToOne
    @NotNull
    @Valid
    private Author author;

    @Deprecated
    public Book(){};

    public Book(@NotBlank String title, @NotBlank @Max(500) String resume, @NotBlank String summary,
                @NotBlank @Min(20) Double price, @NotBlank @Min(100) Long pages,
                @NotBlank Long isbn, OffsetDateTime publishedAt, @Valid @NotNull Author author,
                @Valid @NotNull Category category) {

        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.publishedAt = publishedAt;
        this.author = author;
        this.category = category;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public OffsetDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(OffsetDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
