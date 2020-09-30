package com.casadocodigo.casaDoCodigo.controllers.dto;

import com.casadocodigo.casaDoCodigo.model.Author;

public class DetailedAuthorDto {
    private Long id;
    private String name;
    private String email;
    
    public DetailedAuthorDto(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.email = author.getEmail();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

}
