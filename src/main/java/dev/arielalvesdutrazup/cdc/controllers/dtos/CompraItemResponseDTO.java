package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.CompraItem;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

// 1 LivroResponseDTO.java
// 2 CompraItem.java
// 3 .map(CompraItemRequestDTO::new)
// 4 .collect(Collectors.toSet())
public class CompraItemResponseDTO {

    private Integer quantidade;
    private BigDecimal preco;
    private LivroResponseDTO livro;

    public CompraItemResponseDTO() {
    }

    public CompraItemResponseDTO(CompraItem compraItem) {
        setQuantidade(compraItem.getQuantidade());
        setPreco(compraItem.getPreco());
        setLivro(new LivroResponseDTO(compraItem.getLivro()));
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public CompraItemResponseDTO setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public CompraItemResponseDTO setPreco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public LivroResponseDTO getLivro() {
        return livro;
    }

    public CompraItemResponseDTO setLivro(LivroResponseDTO livro) {
        this.livro = livro;
        return this;
    }

    public static Set<CompraItemResponseDTO> paraDTO(Set<CompraItem> itens) {
        return itens.stream().map(CompraItemResponseDTO::new).collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraItemResponseDTO that = (CompraItemResponseDTO) o;
        return Objects.equals(quantidade, that.quantidade) &&
                Objects.equals(preco, that.preco) &&
                Objects.equals(livro, that.livro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantidade, preco, livro);
    }

    @Override
    public String toString() {
        return "CompraItemResponseDTO{" +
                "quantidade=" + quantidade +
                ", preco=" + preco +
                ", livro=" + livro +
                '}';
    }
}
