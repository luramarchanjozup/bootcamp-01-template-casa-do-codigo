package com.apicasadocodigo.casadocodigo.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private OffsetDateTime instance;

    /*Fala Alberto, tranquilo? to com um dúvida sobre como funciona a vida do objeto entityManager
    * no contêiner */

    @NotEmpty
    @NotNull
    //@UniqueValue(entity = Author.class, attributeName = "email")
    private String email;

    @NotEmpty
    @NotNull
    private String name;

    @Column(columnDefinition="TEXT")
    @Length(max = 500)
    private String description;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Book> booksWhitedByThisAuhtor = new HashSet<>();

    @Deprecated
    public Author() {
    }

    @Deprecated
    public Author(Long id, @NotEmpty @NotNull String email, @NotEmpty @NotNull String name,
                  @Length(max = 500) String description) {

        this.id = id;
        this.email = email;
        this.name = name;
        this.description = description;
    }

    public Author(@NotEmpty @NotNull String email, String name, String description){

        this.email = email;
        this.name = name;
        this.description = description;

        this.instance = OffsetDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return getId().equals(author.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}