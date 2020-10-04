package br.com.casadocodigo.forms;

import br.com.casadocodigo.models.Author;
import br.com.casadocodigo.validation.Unique;

public class AuthorForm {

    @Unique(fieldName = "email", domainClass = Author.class)
    private String email;
    private String name;
    private String description;

    public Author toEntity() {
        return new Author(email, name, description);
    }

    @Deprecated
    public AuthorForm() {};

    public AuthorForm(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
