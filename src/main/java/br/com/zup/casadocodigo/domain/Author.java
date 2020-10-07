package br.com.zup.casadocodigo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter @Setter
@Entity(name = "authors")
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable = false)
    private String name;

    @Column(length = 50, nullable = false, unique=true)
    private String email;

    @Column(length = 400, nullable = false)
    private String description;

    @Column(name = "instant_registration")
    private LocalDateTime instantRegistration = LocalDateTime.now();


    @Deprecated
    public Author(){

    }

    public Author(@NotNull String name,
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
