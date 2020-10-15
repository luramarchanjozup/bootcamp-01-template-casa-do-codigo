package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class ItemCompra {

    @ManyToOne
    @NotNull
    private Livro livro;
    @NotNull
    @Positive
    @Min(value = 1)
    private Integer quantidade;
    @Positive
    private BigDecimal precoAtual;

    @Deprecated
    public ItemCompra(){

    }

    public ItemCompra(@NotNull Livro livro, @Positive Integer quantidade){
        this.livro = livro;
        this.quantidade = quantidade;
        this.precoAtual = livro.getPreco();
    }

    public BigDecimal valorTotal(){
        return precoAtual.multiply(new BigDecimal(quantidade));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCompra that = (ItemCompra) o;
        return livro.equals(that.livro) &&
                quantidade.equals(that.quantidade) &&
                precoAtual.equals(that.precoAtual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livro, quantidade, precoAtual);
    }
}
