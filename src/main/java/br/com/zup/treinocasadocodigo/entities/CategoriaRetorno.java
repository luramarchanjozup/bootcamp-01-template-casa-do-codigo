package br.com.zup.treinocasadocodigo.entities;

/**
 * Contagem de carga intrínseca da classe: 1
 */

public class CategoriaRetorno {

    private String nome;

    //1
    public  CategoriaRetorno (Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
