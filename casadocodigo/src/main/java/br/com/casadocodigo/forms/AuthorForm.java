package br.com.casadocodigo.forms;

import br.com.casadocodigo.models.Author;
import br.com.casadocodigo.validation.Unique;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class AuthorForm {

    @Unique(fieldName = "email", domainClass = Author.class)
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    @Size(max=400)
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
