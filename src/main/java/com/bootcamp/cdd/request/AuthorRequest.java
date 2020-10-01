package com.bootcamp.cdd.request;

import com.bootcamp.cdd.models.Author;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

public class AuthorRequest {
    @NotBlank @Length(min = 3, max = 60, message = "name needs be greater than 3 characters ") private final String name;
    @Email(message = "email format is invalid!") private final String email;
    @NotBlank @Length(min = 2, max = 1000, message = "name needs be greater than 2 characters ") private final String description;

    public AuthorRequest(@NotBlank @Length(min = 3, max = 60, message = "name needs be greater than 3 characters ") String name, @Email(message = "email format is invalid!") String email, @NotBlank @Length(min = 2, max = 1000, message = "name needs be greater than 2 characters ") String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Author toModel () {
        return new Author(this.name, this.email, this.description,  Instant.now());
    }
}
