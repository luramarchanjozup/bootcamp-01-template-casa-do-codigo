package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.CompraItem;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class CompraItemResponseDTO {

    private Integer quantidade;
    private LivroResponseDTO livro;

    public CompraItemResponseDTO() {
    }

    public CompraItemResponseDTO(CompraItem compraItem) {
        setQuantidade(compraItem.getQuantidade());
        setLivro(new LivroResponseDTO(compraItem.getLivro()));
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public CompraItemResponseDTO setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
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
    public String toString() {
        return "CompraItemResponseDTO{" +
                "quantidade=" + quantidade +
                ", livro=" + livro +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraItemResponseDTO that = (CompraItemResponseDTO) o;
        return Objects.equals(quantidade, that.quantidade) &&
                Objects.equals(livro, that.livro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantidade, livro);
    }
}
