package br.com.thyagoribeiro.casadocodigo.rest.contract;

import br.com.thyagoribeiro.casadocodigo.domain.Estado;
import br.com.thyagoribeiro.casadocodigo.domain.Pais;
import br.com.thyagoribeiro.casadocodigo.validator.ExistsValue;
import br.com.thyagoribeiro.casadocodigo.validator.ValueStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// CDD - Total: 4

public class NovoEstadoRequest {

    @NotBlank
    @ExistsValue(domainClass = Estado.class, fieldName = "nome", valueStatus = ValueStatus.NOT_EXISTS) // CDD 3 - Interface @ExistsValue, classe Categoria e ENUM ValueStatus
    private String nome;

    @NotNull
    @ExistsValue(domainClass = Pais.class, fieldName = "id", valueStatus = ValueStatus.EXISTS) // CDD 1 - Classe Pais
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
