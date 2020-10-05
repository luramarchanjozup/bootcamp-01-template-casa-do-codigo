package com.bootcamp.cdd.request;

import com.bootcamp.cdd.models.Author;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

public class AuthorRequest {
    @NotBlank private final String name;
    @NotBlank @Email(message = "email invalido!") private final String email;
    @NotBlank @Length(min = 2, max = 1000) private final String description;

    public AuthorRequest(@NotBlank String name, @NotBlank @Email(message = "email invalido!")  String email, @NotBlank @Length(min = 2, max = 1000) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public Author toModel () {
        return new Author(this.name, this.description,  this.email, Instant.now());
    }
}
