package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.CompraItem;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.stream.Collectors;

public class CompraItemRequestDTO {

    @NotNull(message = "{livroId.notnull}")
    private Long livroId;
    @NotNull(message = "{quantidade.notnull}")
    @Min(value = 1, message = "{quantidade.min}")
    private Integer quantidade;

    public CompraItemRequestDTO() {
    }

    public CompraItemRequestDTO(CompraItem compraItem) {
        var livro = compraItem.getLivro();
        setLivroId(livro.getId());
        setQuantidade(compraItem.getQuantidade());
    }

    public Long getLivroId() {
        return livroId;
    }

    public CompraItemRequestDTO setLivroId(Long livroId) {
        this.livroId = livroId;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public CompraItemRequestDTO setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public static Set<CompraItemRequestDTO> paraDTO(Set<CompraItem> itens) {
        return itens.stream().map(CompraItemRequestDTO::new).collect(Collectors.toSet());
    }
}
