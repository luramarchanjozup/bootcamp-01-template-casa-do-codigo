package com.github.marcoscoutozup.casadocodigo.fluxocompra.itempedido;

import com.github.marcoscoutozup.casadocodigo.livro.Livro;
import com.github.marcoscoutozup.casadocodigo.validator.exists.Exists;
import jdk.swing.interop.SwingInterOpUtils;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

public class ItemPedidoDTO {

    @NotNull
    @Exists(classe = Livro.class)
    private UUID idLivro;

    @NotNull
    @Positive
    private Integer quantidade;

    public ItemPedido toModel(EntityManager entityManager){
        Livro livro = entityManager.find(Livro.class, idLivro);
        System.out.println(livro);
        return new ItemPedido(livro, quantidade);
    }

    public UUID getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(UUID idLivro) {
        this.idLivro = idLivro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Livro buscarLivro(EntityManager entityManager){
        return entityManager.find(Livro.class, idLivro);
    }
}
