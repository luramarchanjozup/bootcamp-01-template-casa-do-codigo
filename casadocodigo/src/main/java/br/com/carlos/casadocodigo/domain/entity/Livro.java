package br.com.carlos.casadocodigo.domain.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(nullable = false, unique = true)
    private String titulo;

    @Getter @Setter
    @Column(nullable = false, length = 500)
    private String resumo;

    @Getter @Setter
    @Column(columnDefinition="TEXT")
    private String sumario;

    @Getter @Setter
    @Column(nullable = false)
    private BigDecimal preco;

    @Getter @Setter
    @Column(nullable = false)
    private int paginas;

    @Getter @Setter
    @Column(nullable = false, unique = true)
    private String isbn;

    @Getter @Setter
    @Column(nullable = false)
    private LocalDate publicao;

    @Getter @Setter
    @ManyToOne
    private  Autor autor;

    @Getter @Setter
    @ManyToOne
    private Categoria categoria;

    @Deprecated
    public Livro(){}

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas, String isbn,
                 LocalDate publicao, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.publicao = publicao;
        this.autor = autor;
        this.categoria = categoria;
    }
}


