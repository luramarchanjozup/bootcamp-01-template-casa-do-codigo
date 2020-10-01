package br.com.treino.casadocodigo.model;

import br.com.treino.casadocodigo.validations.UniqueValue;
import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    @UniqueValue(className = Pais.class, fieldName = "nome",
    message = "Esse páis já foi cadastrado")
    private String nome;

    public String getNome() {
        return nome;
    }
}
