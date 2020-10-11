package com.cdcAPI.api.model.Response;

import com.cdcAPI.model.Autor;

//Complexidade=1
//Autor

public class AutorResponse {

    private String nome;
    private String descricao;

    public AutorResponse(Autor autor) {
        nome = autor.getNome();
        descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
