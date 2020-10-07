package br.com.zup.treinocasadocodigo.entities.compra;

import br.com.zup.treinocasadocodigo.entities.livro.Livro;
import br.com.zup.treinocasadocodigo.entities.pais.Pais;
import br.com.zup.treinocasadocodigo.validators.existid.ExistId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ItensCompraRequest {

    @NotNull
    @ExistId(dominioClasse = Livro.class, nomeCampo = "id")
    private Long idLivro;
    @NotNull
    @Positive
    private int quantidade;

    public ItensCompraRequest(Long idLivro, int quantidade) {
        this.idLivro = idLivro;
        this.quantidade = quantidade;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Itens{" +
                "idLivro=" + idLivro +
                ", quantidade=" + quantidade +
                '}';
    }

    public ItensCompra toModel(EntityManager manager) {
        //1
        Livro livro = manager.find(Livro.class, this.idLivro);
        return new ItensCompra(livro, this.quantidade);
    }
}
