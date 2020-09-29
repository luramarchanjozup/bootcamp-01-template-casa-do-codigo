package com.github.marcoscoutozup.casadocodigo.cadastrocategoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(generator = "uuid4")
    private UUID id;

    @NotBlank
    private String nome;

    @Deprecated
    public Categoria() {
    }

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
