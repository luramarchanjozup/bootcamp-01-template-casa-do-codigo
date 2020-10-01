package br.com.treino.casadocodigo.model;

public class DetalheAutorRequest {

    private String nome;
    private String descricao;

    public DetalheAutorRequest(Autor autor) {
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
