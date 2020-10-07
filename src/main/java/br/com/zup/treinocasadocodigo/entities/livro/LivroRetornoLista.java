package br.com.zup.treinocasadocodigo.entities.livro;

import br.com.zup.treinocasadocodigo.entities.livro.Livro;

/**
 * Contagem de carga intrínseca da classe: 1
 */

public class LivroRetornoLista {
    private Long id;
    private String titulo;

    //1
    public LivroRetornoLista(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
