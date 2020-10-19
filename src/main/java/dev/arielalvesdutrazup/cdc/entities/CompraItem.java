package dev.arielalvesdutrazup.cdc.entities;

import dev.arielalvesdutrazup.cdc.entities.embedded.CupomAplicado;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Set;

import static dev.arielalvesdutrazup.cdc.utils.BigDecimalUtils.discontaPorcentagemDe;

// 1 Livro.java
// 2 Compra.java
@Entity
public class CompraItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(value = 1, message =  "Quantidade mínima é 1!")
    @NotNull(message = "Quantidade é obrigatória!")
    private Integer quantidade;
    @NotNull(message = "Preço do item é obrigatório!")
    private BigDecimal preco;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public CompraItem setPreco(BigDecimal preco) {
        this.preco = preco;
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

    @Override
    public String toString() {
        return "CompraItem{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                ", cadastradoEm=" + cadastradoEm +
                ", livro=" + livro +
                ", compra=" + compra +
                '}';
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

    public static BigDecimal calculaTotalDosItens(Set<CompraItem> itens, CupomAplicado cupomAplicado) {
        var totalDosItens = itens.stream()
                .map(CompraItem::getTotalCompraItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (cupomAplicado != null) {
            return discontaPorcentagemDe(cupomAplicado.getPercentualDeDesconto(), totalDosItens);
        }

        return totalDosItens;
    }
}
