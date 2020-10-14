package br.com.zup.treinocasadocodigo.entities.compra.itemcompra;

import br.com.zup.treinocasadocodigo.entities.livro.Livro;
import br.com.zup.treinocasadocodigo.validators.existid.ExistId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Contagem de carga intrínseca da classe: 3
 */

public class ItemCompraNovoRequest {

    @NotNull
    //1
    @ExistId(dominioClasse = Livro.class, nomeCampo = "id")
    private Long idLivro;
    @NotNull
    @Positive
    private int quantidade;

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

    //1
    public ItemCompra toModel(EntityManager manager) {
        //1
        Livro livro = manager.find(Livro.class, this.idLivro);
        return new ItemCompra(livro, this.quantidade);
    }
}
