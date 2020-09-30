package br.com.casadocodigo.dtos;

import br.com.casadocodigo.models.Author;

public class AuthorDto {

    private String name;

    public AuthorDto(Author author){
        this.name = author.getName();
    }

    public String getName() {
        return name;
    }
}
