package com.bootcamp.cdd.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "name can't be empty")
    @Length(min = 3, max = 60, message = "name needs be greater than 3 characters ")
    private final String name;
    @NotBlank(message = "email is empty!") @Email(message = "email format is invalid!") @Column(unique = true)
    private final String email;
    private final Instant created_at;

    public Author(@NotNull(message = "name can't be empty") @Length(min = 3, max = 60, message = "name needs be greater than 3 characters ") String name, @Email String email, Instant created_at) {
        this.name = name;
        this.email = email;
        this.created_at = created_at;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
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

