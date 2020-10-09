package br.com.zup.treinocasadocodigo.entities.livro;

import java.math.BigDecimal;

/**
 * Contagem de carga intrínseca da classe: 1
 */

public class LivroRetornoLista {
    private Long id;
    private String titulo;
    private BigDecimal preco;

    //1
    public LivroRetornoLista(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.preco = livro.getPreco();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
