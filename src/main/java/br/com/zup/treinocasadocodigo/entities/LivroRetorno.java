package br.com.zup.treinocasadocodigo.entities;

/**
 * Contagem de carga intrínseca da classe: 1
 */

public class LivroRetorno {
    private Long id;
    private String titulo;
//    private String resumo;
//    private String sumario;
//    private BigDecimal preco;
//    private int nPaginas;
//    private String isbn;
//    private LocalDate dataPublicacao;
//    private Categoria categoria;
//    private Autor autor;

    //1
    public LivroRetorno(Livro livro) {
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
