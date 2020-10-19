package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.Categoria;

import javax.validation.constraints.NotBlank;

// 1 Categoria.java
public class CadastrarCategoriaRequestDTO {

    @NotBlank(message = "{nome.notempty}")
    private String nome;

    public CadastrarCategoriaRequestDTO() {}

    public String getNome() {
        return nome;
    }

    public CadastrarCategoriaRequestDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Categoria paraEntidade() {
        return new Categoria().setNome(nome);
    }
}
