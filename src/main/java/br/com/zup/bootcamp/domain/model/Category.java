package br.com.zup.bootcamp.domain.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Collection;

// Intrinsic charge = 1
@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany
    private Collection<Book> books;

    public Category(){}

    public Category(@NotBlank String name){
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBook(Book book){
        this.books.add(book);
    }
}
