package com.cdcAPI.api.model.Response;

import com.cdcAPI.model.Categoria;

public class CategoriaResponse {

    private String nome;

    public CategoriaResponse(Categoria categoria) {
        nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
