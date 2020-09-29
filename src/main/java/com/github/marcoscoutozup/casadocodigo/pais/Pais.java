package com.github.marcoscoutozup.casadocodigo.pais;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.marcoscoutozup.casadocodigo.estado.Estado;
import com.github.marcoscoutozup.casadocodigo.exceptions.NotFoundException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Entity
public class Pais {

    @Id
    @GeneratedValue(generator = "uuid4")
    private UUID id;

    @NotBlank
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "pais")
    private List<Estado> estados;

    @Deprecated
    public Pais() {
    }

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void validaSeEstadoPertenceAoPais(UUID estadoId){
        if(!estados.stream().anyMatch(estado -> estado.getId().equals(estadoId))){
            throw new NotFoundException("Estado não pertence ao " + nome);
        }
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
