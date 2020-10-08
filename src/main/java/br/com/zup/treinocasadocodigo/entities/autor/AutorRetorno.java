package br.com.zup.treinocasadocodigo.entities.autor;

/**
 * Contagem de carga intrínseca da classe: 1
 */

public class AutorRetorno {

    private String nome;
    private String descricao;

    //1
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
