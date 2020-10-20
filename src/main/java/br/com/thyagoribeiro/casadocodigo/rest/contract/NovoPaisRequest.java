package br.com.thyagoribeiro.casadocodigo.rest.contract;

import br.com.thyagoribeiro.casadocodigo.domain.Pais;
import br.com.thyagoribeiro.casadocodigo.validator.Exist;

import javax.validation.constraints.NotBlank;

// CDD - Total: 1

public class NovoPaisRequest {

    @NotBlank
    @Exist(domainClass = Pais.class, fieldName = "nome", expected = false) // CDD 1 - classe Pais
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
