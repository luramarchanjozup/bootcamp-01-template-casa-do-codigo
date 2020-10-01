package com.bootcamp.cdd.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AuthorRequest {
    @NotBlank private String name;
    @Email @NotBlank private String email;

    public AuthorRequest(@NotBlank String name, @Email @NotBlank String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
