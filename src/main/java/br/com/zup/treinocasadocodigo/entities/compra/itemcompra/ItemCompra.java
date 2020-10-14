package br.com.zup.treinocasadocodigo.entities.compra.itemcompra;

import br.com.zup.treinocasadocodigo.entities.livro.Livro;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Contagem de carga intrínseca da classe: 1
 */

@Entity
public class ItemCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    //1
    private Livro livro;

    @NotNull
    @Positive
    private int quantidade;

    public ItemCompra(){}

    public ItemCompra(@NotNull Livro livro, @NotNull @Positive int quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItensCompra{" +
                "id=" + id +
                ", livro=" + livro +
                ", quantidade=" + quantidade +
                '}';
    }
}
