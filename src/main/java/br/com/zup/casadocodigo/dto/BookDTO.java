package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.annotations.UniqueValue;
import br.com.zup.casadocodigo.domain.Author;
import br.com.zup.casadocodigo.domain.Book;
import br.com.zup.casadocodigo.domain.Category;
import br.com.zup.casadocodigo.annotations.ExistsValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookDTO {

    @NotBlank(message = "is required")
    @UniqueValue(domainClass = Book.class, fieldName = "title", message = "already registered")
    private String title;

    @NotBlank(message = "is required") @Size(max = 500)
    private String resume;

    @NotBlank
    private String summary;

    @NotNull(message = "is required") @Min(20)
    private BigDecimal price;

    @NotNull(message = "is required") @Min(100)
    private int numberPages;

    @NotBlank(message = "is required")
    @UniqueValue(domainClass = Book.class, fieldName = "isbn", message = "already registered")
    private String isbn;

    @Future @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate datePublish;


    @NotNull(message = "is required")
    @ExistsValue(domainClass = Category.class, fieldName = "id", message = "the category does not exist")
    private Long categoryId;


    @NotNull(message = "is required")
    @ExistsValue(domainClass = Author.class, fieldName = "id", message = "the author does not exist")
    private Long authorId;


    @Deprecated
    public BookDTO() {
    }

    public BookDTO(@NotBlank String title, @NotBlank @Size(max = 500) String resume, @NotBlank String summary,
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

    public Book toModel(EntityManager manager){
        Author author = manager.find(Author.class, this.authorId);
        Category category = manager.find(Category.class, this.categoryId);

        return new Book(this.title, this.resume, this.summary, this.price,
                        this.numberPages, this.isbn, this.datePublish, category, author);
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(LocalDate datePublish) {
        this.datePublish = datePublish;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
