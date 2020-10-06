package br.com.zup.bootcamp.domain.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

// Intrinsic charge = 3
@Entity
public class Book implements Serializable {

    // Natural primary key
    @Id
    private String isbn;

    @Column(nullable = false, unique = true)
    private String title;

    @Length(max = 500)
    @Column(nullable = false)
    private String resume;

    @Column
    private String summary;

    @Min(20)
    @Column(nullable = false)
    private float price;

    @Min(100)
    @Column(nullable = false)
    private int pages;

    private LocalDate publicationDate;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private Author author;

    @OneToMany(mappedBy = "book")
    private Collection<Item> items;

    public Book(){}

    public Book(@NotBlank String isbn, @NotBlank String title, @NotBlank @Length(max = 500) String resume,
                String summary, @NotNull @Min(20) float price, @NotNull @Min(100) int pages,
                LocalDate publicationDate, @NotNull Category category, @NotNull Author author) {
        this.isbn = isbn;
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.pages = pages;
        this.publicationDate = publicationDate;
        this.category = category;
        this.author = author;
    }

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

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    public Collection<Item> getItems() {
        return items;
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

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void addItem(Item item){
        this.items.add(item);
    }
}
