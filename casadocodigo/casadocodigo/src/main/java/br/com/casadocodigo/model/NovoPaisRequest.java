package br.com.casadocodigo.model;

import br.com.casadocodigo.validator.ValorUnico;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    @ValorUnico(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
