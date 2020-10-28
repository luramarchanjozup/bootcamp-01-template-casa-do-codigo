package com.apicasadocodigo.casadocodigo.request;

import com.apicasadocodigo.casadocodigo.model.Author;
import com.apicasadocodigo.casadocodigo.model.Book;
import com.apicasadocodigo.casadocodigo.model.Category;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import com.apicasadocodigo.casadocodigo.util.ConvertDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookRequest {

    @NotBlank
    @NotNull
    private String title;

    @Length(max = 500)
    @NotBlank
    @NotNull
    private String summary;

    @NotBlank
    @NotNull
    private String chapeters;

    @Min(20)
    @NotNull
    private BigDecimal price;

    @Min(100)
    @NotNull
    private int pageQuantity;

    @NotBlank
    @NotNull
    private String isbn;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @NotNull
    @Future
    private LocalDate releaseDate;

    @NotNull
    private Category category;//1

    @NotNull
    private Author author;//2

    public BookRequest(@NotBlank @NotNull String title, @Length(max = 500)
    @NotBlank @NotNull String summary, @NotBlank @NotNull String chapeters,
                       @Min(20) @NotNull BigDecimal price, @Min(100) @NotNull int pageQuantity,
                       @NotBlank @NotNull String isbn, @NotNull @NotEmpty String releaseDate,
                       @NotNull Category category, @NotNull Author author) {

        this.title = title;
        this.summary = summary;
        this.chapeters = chapeters;
        this.price = price;
        this.pageQuantity = pageQuantity;
        this.isbn = isbn;
        this.releaseDate = ConvertDate.toLocalDate(releaseDate);
        this.category = category;
        this.author = author;
    }

    public String getIsbn() { return isbn; }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Book toModel(GenericDAO genericDAO){ //3
        return new Book(title, summary, chapeters, price, pageQuantity,
                isbn, releaseDate,
                genericDAO.findEntityDepedenceDyId(Category.class,  category.getId()),
                genericDAO.findEntityDepedenceDyId(Author.class, author.getId()));
    }
    //PONTOS CDD: 3
}
