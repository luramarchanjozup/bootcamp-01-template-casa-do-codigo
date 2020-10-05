package com.bootcamp.cdd.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @Length(min = 3, max = 60)
    private String description;
    @NotBlank
    @Email
    private String email;
    private Instant created_at;

    public Author(@NotBlank String name, @Length(min = 3, max = 60) String description, @NotBlank @Email String email, Instant created_at) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.created_at = created_at;
    }

    public Author() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public Instant getCreated_at() {
        return created_at;
    }
}

