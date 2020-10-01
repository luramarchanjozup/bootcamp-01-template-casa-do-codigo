package com.bootcamp.cdd.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "name can't be empty")
    @Length(min = 3, max = 60, message = "name needs be greater than 3 characters ")
    private String name;
    @Email
    private String email;
    private Instant created_at;

    public Author(@NotNull(message = "name can't be empty") @Length(min = 3, max = 60, message = "name needs be greater than 3 characters ") String name, @Email String email, Instant created_at) {
        this.name = name;
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

    public Instant getCreated_at() {
        return created_at;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}

