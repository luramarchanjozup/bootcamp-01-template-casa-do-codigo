package com.casadocodigo.casaDoCodigo.controllers.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.casadocodigo.casaDoCodigo.model.Author;

public class AuthorDto {
    private Long id;
    private String name;

    public AuthorDto(Author author) {
        this.id = author.getId();
        this.name = author.getName();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public static List<AuthorDto> convert(List<Author> authors) {
        return authors.stream().map(AuthorDto::new).collect(Collectors.toList());
    }

}
