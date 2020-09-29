package com.github.marcoscoutozup.casadocodigo.autor;

public class AutorResponse {

    private String nome;

    public AutorResponse(Autor autor) {
        this.nome = autor.getNome();
    }

    public String getNome() {
        return nome;
    }
}
