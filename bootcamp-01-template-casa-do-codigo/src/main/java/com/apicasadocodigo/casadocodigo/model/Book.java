package com.apicasadocodigo.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private String title;

    @Column(columnDefinition="TEXT")
    @Size(max = 500)
    @NotBlank
    @NotNull
    private String summary;

    @Column(columnDefinition="TEXT")
    @NotBlank
    @NotNull
    private String chapeters;

    @Min(20)
    @NotNull
    private BigDecimal price;

    @Min(100)
    @NotNull
    @Column(name = "page_quantity")
    private int pageQuantity;

    @NotBlank
    @NotNull
    private String isbn;

    @Future
    @Column(name = "release_date")
    private LocalDate releaseDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Deprecated
    public Book(){

    }

    public Book(@NotBlank @NotNull String title, @Size(max = 500) @NotBlank @NotNull String summary,
                @NotBlank @NotNull String chapeters, @Min(20) @NotNull BigDecimal price,
                @Min(100) @NotNull int pageQuantity, @NotBlank @NotNull String isbn,
                @Future LocalDate releaseDate, @NotNull Category category, @NotNull Author author) {

        this.title = title;
        this.summary = summary;
        this.chapeters = chapeters;
        this.price = price;
        this.pageQuantity = pageQuantity;
        this.isbn = isbn;
        this.releaseDate = releaseDate;
        this.category = category;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() { return title; }

    public String getSummary() {
        return summary;
    }

    public String getChapeters() {
        return chapeters;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getPageQuantity() {
        return pageQuantity;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
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
        return Objects.hash(id);
    }
}
