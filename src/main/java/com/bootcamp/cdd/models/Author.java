package com.bootcamp.cdd.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
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
    private Date created_at;

    public Author(@NotNull(message = "name can't be empty") @Length(min = 3, max = 60, message = "name needs be greater than 3 characters ") String name, @Email String email, Date created_at) {
        this.name = name;
        this.email = email;
        created_at = created_at;
    }

    public Author() {
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}

