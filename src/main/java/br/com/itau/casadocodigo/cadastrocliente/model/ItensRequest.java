package br.com.itau.casadocodigo.cadastrocliente.model;

import br.com.itau.casadocodigo.novolivro.model.Livro;
import br.com.itau.casadocodigo.validador.AtributoUnico;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ItensRequest {

    @NotNull
    @AtributoUnico(nomeDoAtributo = "id", classeDeDominio = Livro.class)
    private final Long idLivro;
    @NotNull
    @Positive
    private final Long quantidade;

    public ItensRequest(@NotNull Long idLivro, @NotNull @Positive Long quantidade) {
        this.idLivro = idLivro;
        this.quantidade = quantidade;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public Itens toItensModel() {
        return new Itens(this.idLivro, this.quantidade);
    }
//1
    public BigDecimal calculaPreco(EntityManager entityManager) {
        Livro livro = entityManager.find(Livro.class, this.idLivro);
        return livro.getPreco().multiply(BigDecimal.valueOf(this.quantidade));
    }
}
