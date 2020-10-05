package br.com.thyagoribeiro.casadocodigo.rest.contract;

import br.com.thyagoribeiro.casadocodigo.domain.Categoria;
import br.com.thyagoribeiro.casadocodigo.validator.ExistsValue;
import br.com.thyagoribeiro.casadocodigo.validator.ValueStatus;

import javax.validation.constraints.NotBlank;

// CDD - Total: 2

public class NovaCategoriaRequest {

    @NotBlank
    @ExistsValue(domainClass = Categoria.class, fieldName = "nome", valueStatus = ValueStatus.NOT_EXISTS) // CDD 2 - Interface UniqueValue e classe Categoria
    private String nome;

    @Deprecated
    public NovaCategoriaRequest() {
    }

    public NovaCategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}
