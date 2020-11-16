package br.com.casadocodigo.forms;
import br.com.casadocodigo.models.Author;
import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.models.Category;
import br.com.casadocodigo.validation.ExistsId;
import br.com.casadocodigo.validation.Unique;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.Optional;

public class BookForm {

    @NotBlank
    @Unique(fieldName = "title", domainClass = Book.class)
    private String title;

    @NotBlank
    private String resume;

    @NotBlank
    private String summary;

    @Min(20)
    @NotNull
    private Double price;

    @NotNull
    @Min(100)
    private Long pages;

    @NotNull
    @Unique(fieldName = "isbn", domainClass = Book.class)
    private Long Isbn;

    @Future
    private OffsetDateTime publishedAt;

    @ExistsId(fieldName = "id", domainClass = Author.class)
    private Long authorId;

    @ExistsId(fieldName = "id", domainClass = Category.class)
    private Long categoryId;


    public Book toEntity(EntityManager entityManager){

        Author author = entityManager.find(Author.class, authorId);
        Category category = entityManager.find(Category.class, categoryId);

        Assert.state( author != null, "Você esta querendo cadastrar um livro para um autor que nao existe no banco "+ authorId);
        Assert.state( category != null, "Você esta querendo cadastrar um livro para uma categoria que nao existe no banco "+categoryId);

        return new Book(title, resume, summary, price, pages, Isbn, publishedAt, author, category) ;

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

    public void setPublishedAt(OffsetDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
