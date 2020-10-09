package br.com.ecommerce.cdc.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

/**
 * Carga Intrínseca máxima permitida - 9
 * Carga Intrínseca da classe - 0
 *
 */

@Entity
@Table(name = "author")
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(max = 400)
    private String description;
    @NotNull
    private LocalDateTime instant;

    public Autor() {
    }

    public Autor(@NotBlank String name, @NotBlank String email, @NotBlank @Max(400) String description, @NotNull LocalDateTime instant) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.instant = instant;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getInstant() {
        return instant;
    }

    public Long id(){
        return getId();
    }

    public String nome(){
        return getName();
    }

    public String email(){
        return getEmail();
    }

    public String descricao(){
        return getDescription();
    }

    public LocalDateTime momento(){
        return getInstant();
    }
}
