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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }


}
