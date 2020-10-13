package br.com.thyagoribeiro.casadocodigo.rest.contract;

import br.com.thyagoribeiro.casadocodigo.domain.Categoria;
import br.com.thyagoribeiro.casadocodigo.validator.Exist;

import javax.validation.constraints.NotBlank;

// CDD - Total: 1

public class NovaCategoriaRequest {

    @NotBlank
    @Exist(domainClass = Categoria.class, fieldName = "nome", expected = false) // CDD 1 - Classe Categoria
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
