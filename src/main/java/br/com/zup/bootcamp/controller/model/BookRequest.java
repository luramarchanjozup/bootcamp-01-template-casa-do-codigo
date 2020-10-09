package br.com.zup.bootcamp.controller.model;

import br.com.zup.bootcamp.controller.validator.annotation.Exist;
import br.com.zup.bootcamp.controller.validator.annotation.Unique;
import br.com.zup.bootcamp.domain.model.Author;
import br.com.zup.bootcamp.domain.model.Book;
import br.com.zup.bootcamp.domain.model.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

// Intrinsic charge = 3
public class BookRequest {
    @NotBlank(message = "Isbn is mandatory")
    @Unique(message = "Isbn already registered", fieldName = "isbn", domainClass = Book.class)
    private String isbn;

    @NotBlank(message = "Title is mandatory")
    @Unique(message = "Title already registered", fieldName = "title", domainClass = Book.class)
    private String title;

    @NotBlank(message = "Resume is mandatory")
    @Length(max = 500, message = "Resume maximum c")
    private String resume;

    private String summary;

    @Min(value = 20, message = "Price minimum value is 20")
    @NotNull(message = "Price is mandatory")
    private float price;

    @Min(value = 100, message = "Pages minimum values is 100")
    @NotNull(message = "Pages is mandatory")
    private int pages;

    @Future(message = "Publication date needs to be in the future")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;

    @NotBlank(message = "Category is mandatory")
    @Exist(message = "Category not found", fieldName = "id", domainClass = Category.class)
    private String category;

    @NotBlank(message = "Author is mandatory")
    @Exist(message = "Author not found", fieldName = "id", domainClass = Author.class)
    private String author;

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public String getSummary() {
        return summary;
    }

    public float getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book convert(){
        Author author = new Author();
        author.setId(this.author);

        Category category = new Category();
        category.setId(this.category);

        return new Book(this.isbn, this.title, this.resume, this.summary, this.price, this.pages, this.publicationDate,
                category, author);
    }
}
