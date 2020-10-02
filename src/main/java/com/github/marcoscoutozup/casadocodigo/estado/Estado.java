package com.github.marcoscoutozup.casadocodigo.estado;

import com.github.marcoscoutozup.casadocodigo.pais.Pais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Estado {

    @Id
    @GeneratedValue(generator = "uuid4")
    private UUID id;

    @NotBlank
    private String nome;

    @NotNull
    @ManyToOne
    private Pais pais;

    @Deprecated
    public Estado() {
    }

    public Estado(@NotBlank String nome) {
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais=" + pais.getNome() +
                '}';
    }
}
