package com.bootcamp.cdd.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "nome precisa ser preenchido") @Length(min = 3, max = 80, message = "descrição precisa ter mais de 3 caracteres")
    private String name;
    @Length(min = 3, max = 1000, message = "descrição precisa ter mais de 3 caracteres")
    private String description;
    @NotBlank(message = "email precisa ser preenchido") @Email(message = "email invalido!")
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:SSS'Z'")
    private final LocalDateTime created_at = LocalDateTime.now();

    public Author(@NotBlank String name, @Length(min = 3, max = 60) String description, @NotBlank @Email String email) {
        this.name = name;
        this.description = description;
        this.email = email;
    }

    public Author() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }
}

