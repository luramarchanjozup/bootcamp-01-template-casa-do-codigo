package br.com.treino.casadocodigo.model;

import br.com.treino.casadocodigo.validations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValue(className = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }
}
