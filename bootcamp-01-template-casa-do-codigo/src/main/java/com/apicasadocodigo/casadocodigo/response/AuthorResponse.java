package com.apicasadocodigo.casadocodigo.response;

import com.apicasadocodigo.casadocodigo.model.Author;

public class AuthorResponse {

    private String name;
    private String description;

    public AuthorResponse(Author author) {
        this.name = author.getName();
        this.description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
