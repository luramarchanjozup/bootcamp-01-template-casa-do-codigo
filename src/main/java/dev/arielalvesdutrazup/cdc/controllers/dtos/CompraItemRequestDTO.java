package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.CompraItem;
import dev.arielalvesdutrazup.cdc.entities.Livro;
import dev.arielalvesdutrazup.cdc.services.GerenciadorDeServico;
import org.springframework.util.Assert;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// 1 CompraItem.java
// 2 .map(CompraItemRequestDTO::new)
// 3 .collect(Collectors.toSet())
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

    public static Set<CompraItem> paraEntidade(
            GerenciadorDeServico gerenciadorDeServico,
            Set<CompraItemRequestDTO> itensDTO) {

        Assert.notNull(itensDTO, "É obrigatório ao menos 1 item de compra!");

        var livroService = gerenciadorDeServico.instanciaDeLivroService();

        Set<CompraItem> itens = new HashSet<>();
        itensDTO.forEach(itemDTO -> {
            Livro livro = livroService.buscaPeloId(itemDTO.getLivroId());
            Integer quantidade = itemDTO.getQuantidade();
            CompraItem item = new CompraItem()
                    .setPreco(livro.getPreco())
                    .setLivro(livro)
                    .setQuantidade(quantidade);
            itens.add(item);
        });

        return itens;
    }

}
