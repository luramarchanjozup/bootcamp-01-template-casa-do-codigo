package br.com.ecommerce.cdc.domain.request;

import br.com.ecommerce.cdc.anotacao.NotDuplicated;
import br.com.ecommerce.cdc.domain.model.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {
    @NotBlank
    @NotDuplicated(nameClass = "Categoria", fieldName = "nome")
    private String nome;

    public CategoriaRequest() {
    }

    public CategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toCategoria(){
        return new Categoria(this.getNome());
    }

    @Override
    public String toString() {
        return "CategoriaRequest{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
