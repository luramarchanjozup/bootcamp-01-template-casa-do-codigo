package com.example.apicasadocodigo.localidade;

import com.example.apicasadocodigo.compartilhado.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {
    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "Este país já está cadastrado.")
    private String nome;

    public Pais toModel() {
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
