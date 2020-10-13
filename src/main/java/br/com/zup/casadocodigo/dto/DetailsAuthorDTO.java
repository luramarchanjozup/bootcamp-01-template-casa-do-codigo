package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.domain.Author;
import br.com.zup.casadocodigo.domain.Book;

public class DetailsAuthorDTO {

    private String name;
    private String description;

    public DetailsAuthorDTO (Author author) {
        name = author.getName();
        description = author.getDescription();
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
