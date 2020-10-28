package com.apicasadocodigo.casadocodigo.request;

import com.apicasadocodigo.casadocodigo.model.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AuthorRequest {

    @Email
    @NotNull
    @NotBlank
    //@UniqueValue(entity = Author.class, attributeName = "email")
    private String email;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 400)
    private String description;

    public AuthorRequest(@Email @NotNull @NotBlank String email,
                         @NotNull @NotBlank String name,
                         @NotNull @NotBlank @Size(max = 400) String description) {

        this.email = email;
        this.name = name;
        this.description = description;
    }

    public Author toModel(){
        return new Author(email, name, description);
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

}
