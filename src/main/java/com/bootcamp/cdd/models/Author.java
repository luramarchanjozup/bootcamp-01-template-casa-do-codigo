package com.bootcamp.cdd.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "authors")
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
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }
}

