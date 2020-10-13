package br.com.treino.casadocodigo.request;

import br.com.treino.casadocodigo.model.Categoria;
import br.com.treino.casadocodigo.validations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValue(className = Categoria.class, fieldName = "nome",
            message = "Essa categoria já foi cadastrada") //1
    private String nome;

    public String getNome() {
        return nome;
    }
}
