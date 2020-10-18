package io.github.evertoncnsouza.rest.dto;

import io.github.evertoncnsouza.domain.entity.Pais;
import io.github.evertoncnsouza.validation.constraint.valitation.UniqueValue;
import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
