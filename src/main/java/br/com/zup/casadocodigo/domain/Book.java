package br.com.zup.casadocodigo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String resume;
    private String summary;
    private BigDecimal price;
    private int numberPages;
    private String isbn;
    private LocalDate datePublish;
    private Long categoryId;
    private Long authorId;

    @Deprecated
    public Book() {
    }

    public Book(@NotBlank String title, @NotBlank @Size(max = 500) String resume, @NotBlank String summary,
                @NotNull @Min(20) BigDecimal price,
                @NotNull @Min(100) int numberPages,
                @NotBlank String isbn,
                @Future @NotNull LocalDate datePublish,
                @NotNull Long category,
                @NotNull Long author) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.numberPages = numberPages;
        this.isbn = isbn;
        this.datePublish = datePublish;
        this.categoryId = category;
        this.authorId = author;
    }
}
