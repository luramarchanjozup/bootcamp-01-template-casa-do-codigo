package br.com.ecommerce.cdc.domain.response;

import br.com.ecommerce.cdc.domain.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Carga Intrínseca máxima permitida - 9
 * Carga Intrínseca da classe - 1
 *
 */

public class AutorResponse {

    private Long id;
    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(max = 400)
    private String description;
    @NotNull
    private LocalDateTime instant;
    // +1
    public AutorResponse(Autor autor){
        this.id = autor.getId();
        this.nome = autor.getName();
        this.email = autor.getEmail();
        this.description = autor.getDescription();
        this.instant = autor.getInstant();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public LocalDateTime getInstant() {
        return instant;
    }

    public void setInstant(LocalDateTime instant) {
        this.instant = instant;
    }
}
