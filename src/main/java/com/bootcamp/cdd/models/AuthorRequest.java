package com.bootcamp.cdd.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

public class AuthorRequest {
    @NotBlank @Length(min = 3, max = 60, message = "name needs be greater than 3 characters ") private String name;
    @NotBlank(message = "email is empty!") @Email(message = "email format is invalid!") private String email;

    public AuthorRequest(@NotBlank String name, @Email @NotBlank String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Author toModel () {
        return new Author(this.name, this.email, Instant.now());
    }
}
