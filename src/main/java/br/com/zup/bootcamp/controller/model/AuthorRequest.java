package br.com.zup.bootcamp.controller.model;

import br.com.zup.bootcamp.controller.validator.annotation.Unique;
import br.com.zup.bootcamp.database.model.Author;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

// Intrinsic charge = 1
public class AuthorRequest {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Unique(message = "Email already registered", fieldName = "email", domainClass = Author.class)
    @Email(message = "Email invalid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Length(max = 400, message = "Description maximum character is 400")
    @NotBlank(message = "Description is mandatory")
    private String description;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public Author convert(){
        return new Author(this.name, this.email, this.description);
    }
}
