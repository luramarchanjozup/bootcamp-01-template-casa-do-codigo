package com.bootcamp.cdd.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "name can't be empty")
    @Length(min = 3, max = 60, message = "name needs be greater than 3 characters ")
    private final String name;
    @Length(min = 3, max = 60, message = "description needs be greater than 3 characters ")
    private final String description;
    @NotEmpty(message = "email is empty!") @Email(message = "email format is invalid!") @Column(unique = true)
    private final String email;
    private final Instant created_at;

    public Author(@NotEmpty(message = "name can't be empty") @Length(min = 3, max = 60, message = "name needs be greater than 3 characters ") String name, @NotEmpty(message = "email is empty!") @Email(message = "email format is invalid!") String email, @Length(min = 3, max = 60, message = "description needs be greater than 3 characters ") String description, Instant created_at) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.created_at = created_at;
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

