package br.com.zup.treinocasadocodigo.entities;

public class AutorRetorno {

    private String nome;
    private String descricao;

    public AutorRetorno(Autor autor) {
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
