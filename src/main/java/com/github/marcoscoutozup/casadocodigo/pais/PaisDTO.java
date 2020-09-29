package com.github.marcoscoutozup.casadocodigo.pais;

import com.github.marcoscoutozup.casadocodigo.validator.unique.Unique;

import javax.validation.constraints.NotBlank;

public class PaisDTO {

    @NotBlank
    @Unique(campo = "nome", classe = Pais.class)
    private String nome;

    public Pais toModel(){
        return new Pais(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
