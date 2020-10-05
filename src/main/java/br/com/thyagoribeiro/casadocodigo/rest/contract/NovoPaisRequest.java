package br.com.thyagoribeiro.casadocodigo.rest.contract;

import br.com.thyagoribeiro.casadocodigo.domain.Pais;
import br.com.thyagoribeiro.casadocodigo.validator.ExistsValue;
import br.com.thyagoribeiro.casadocodigo.validator.ValueStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// CDD - Total: 3

public class NovoPaisRequest {

    @NotBlank
    @ExistsValue(domainClass = Pais.class, fieldName = "nome", valueStatus = ValueStatus.NOT_EXISTS) // CDD 3 - Interface @ExistsValue, classe Pais e ENUM ValueStatus
    private String nome;

    @Deprecated
    public NovoPaisRequest() {
    }

    public NovoPaisRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(nome);
    }

}
