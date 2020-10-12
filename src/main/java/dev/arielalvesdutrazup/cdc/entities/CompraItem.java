package dev.arielalvesdutrazup.cdc.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
public class CompraItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    private OffsetDateTime cadastradoEm;
    @ManyToOne
    private Livro livro;
    @ManyToOne(cascade = CascadeType.ALL)
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

    /**
     * Retorna o preço do livro multiplicado pela quantidade.
     *
     * @return
     */
    public BigDecimal getTotalCompraItem() {
        return livro.getPreco().multiply(new BigDecimal(quantidade));
    }

    @Override
    public String toString() {
        return "CompraItem{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", cadastradoEm=" + cadastradoEm +
                ", livro=" +livro +
                ", compra=" +compra +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraItem that = (CompraItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
