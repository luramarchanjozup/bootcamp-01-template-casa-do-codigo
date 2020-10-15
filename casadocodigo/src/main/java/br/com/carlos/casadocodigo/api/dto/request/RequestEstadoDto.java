package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.Unique;
import br.com.carlos.casadocodigo.domain.entity.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RequestEstadoDto {

    @NotBlank(message = "é obrigatorio") @Unique(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @Valid @NotNull
    private RequestPaisId pais;

    public RequestEstadoDto(){}

    public Estado toEntity(EntityManager manager) {
        var pais = manager.find(Pais.class, this.pais.getId());
        return new Estado(nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RequestPaisId getPais() {
        return pais;
    }

    public void setPais(RequestPaisId pais) {
        this.pais = pais;
    }
}
