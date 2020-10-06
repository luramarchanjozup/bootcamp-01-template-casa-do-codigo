package com.github.marcoscoutozup.casadocodigo.categoria;

import com.github.marcoscoutozup.casadocodigo.validator.unique.Unique;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

    @NotBlank
    @Unique(campo = "nome", classe = Categoria.class)
    private String nome;
            //1
    public Categoria toModel(){
        return new Categoria(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
