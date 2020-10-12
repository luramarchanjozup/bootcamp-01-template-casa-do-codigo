package br.com.treino.casadocodigo.response;

import br.com.treino.casadocodigo.model.Autor;

public class DetalheAutorResponse {

    private String nome;
    private String descricao;

    public DetalheAutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
