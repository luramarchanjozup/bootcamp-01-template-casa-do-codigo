package br.com.casadocodigo.model;


import br.com.casadocodigo.validator.ValorUnico;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @ValorUnico(domainClass = Categoria.class, fieldName = "nome", message = "o nome da categoria deve ser único")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public Categoria toCategoria() {
        return new Categoria(this.nome);
    }
}
