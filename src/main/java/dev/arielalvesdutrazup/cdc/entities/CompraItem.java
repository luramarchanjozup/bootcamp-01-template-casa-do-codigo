package dev.arielalvesdutrazup.cdc.entities;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
public class CompraItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    private OffsetDateTime cadastradoEm;
    @ManyToOne
    private Livro livro;
    @ManyToOne
    private Compra compra;

    public Long getId() {
        return id;
    }

    public CompraItem setId(Long id) {
        this.id = id;
        return this;
    }

    public Livro getLivro() {
        return livro;
    }

    public CompraItem setLivro(Livro livro) {
        this.livro = livro;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public CompraItem setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public OffsetDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public CompraItem setCadastradoEm(OffsetDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
        return this;
    }

    public Compra getCompra() {
        return compra;
    }

    public CompraItem setCompra(Compra compra) {
        this.compra = compra;
        return this;
    }
}
