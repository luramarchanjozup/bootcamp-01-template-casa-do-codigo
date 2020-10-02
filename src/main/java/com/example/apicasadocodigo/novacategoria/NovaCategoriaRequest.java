package com.example.apicasadocodigo.novacategoria;

import com.example.apicasadocodigo.compartilhado.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {
    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Esta categoria já está cadastrada.")
    private String nome;

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
