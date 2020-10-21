package br.com.itau.casadocodigo.cadastrocliente.model;

import br.com.itau.casadocodigo.novolivro.model.Livro;
import br.com.itau.casadocodigo.validador.AtributoUnico;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Embeddable
public class Itens {

    @NotNull
    @AtributoUnico(nomeDoAtributo = "id", classeDeDominio = Livro.class)
    private Long idLivro;
    @NotNull
    @Positive
    private Long quantidade;

    @Deprecated
    public Itens() {
    }

    public Itens(@NotNull Long idLivro, @NotNull @Positive Long quantidade) {
        this.idLivro = idLivro;
        this.quantidade = quantidade;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
