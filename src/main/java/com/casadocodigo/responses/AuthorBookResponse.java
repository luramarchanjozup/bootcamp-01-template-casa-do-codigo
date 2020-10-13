package com.casadocodigo.responses;

import com.casadocodigo.entity.Author;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class AuthorBookResponse {

    private String name;
    private String email;
    private String description;

    public AuthorBookResponse(Author author) {
        this.name = author.getName();
        this.email = author.getEmail();
        this.description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }
}
