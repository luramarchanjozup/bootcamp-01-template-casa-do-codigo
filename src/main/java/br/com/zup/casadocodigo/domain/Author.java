package br.com.zup.casadocodigo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter @Setter
@Entity(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String description;
    private LocalDateTime instantRegistration = LocalDateTime.now();


    @Deprecated
    public Author(){

    }

    public Author(@NotBlank String name,
                  @NotBlank @Email String email,
                  @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }
/*
    @Override
    public String toString() {
        return "Autor [id=" + id + ", name=" + name + ", email=" + email
                + ", description=" + description + ", instantRegistration="
                + instantRegistration + "]";
    }*/
}
