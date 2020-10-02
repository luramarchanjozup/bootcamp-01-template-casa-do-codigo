package com.example.apicasadocodigo.localidade;

import com.example.apicasadocodigo.compartilhado.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEstadoRequest {
    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;
    @NotNull
    private Long idPais;

    public Estado toModel(EntityManager manager) {
        @NotNull Pais pais = manager.find(Pais.class, idPais);
        return new Estado(nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }
}