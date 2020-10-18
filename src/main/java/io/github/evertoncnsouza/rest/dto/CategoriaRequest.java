package io.github.evertoncnsouza.rest.dto;

import io.github.evertoncnsouza.domain.entity.Categoria;
import io.github.evertoncnsouza.validation.constraint.valitation.UniqueValue;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

//Não tem PCI
public class CategoriaRequest {

    @NotEmpty(message = "{nome.categoria.obrigatorio}")
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    @Column(unique = true)
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}


