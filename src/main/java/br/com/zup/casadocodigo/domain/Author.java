package br.com.zup.casadocodigo.domain;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getInstantRegistration() {
        return instantRegistration;
    }

    public void setInstantRegistration(LocalDateTime instantRegistration) {
        this.instantRegistration = instantRegistration;
    }
}
