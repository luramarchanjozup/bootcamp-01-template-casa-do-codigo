package br.com.thyagoribeiro.casadocodigo.rest.contract;

import br.com.thyagoribeiro.casadocodigo.domain.Estado;
import br.com.thyagoribeiro.casadocodigo.domain.Pais;
import br.com.thyagoribeiro.casadocodigo.validator.Exist;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// CDD - Total: 2

public class NovoEstadoRequest {

    @NotBlank
    @Exist(domainClass = Estado.class, fieldName = "nome", expected = false) // CDD 2 - Classe Estado
    private String nome;

    @NotNull
    @Exist(domainClass = Pais.class, fieldName = "id", expected = true) // CDD 1 - Classe Pais
    private Long paisId;

    @Deprecated
    public NovoEstadoRequest() {
    }

    public NovoEstadoRequest(@NotBlank String nome, @NotNull Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public Estado toModel() {
        return new Estado(nome, paisId);
    }
}
