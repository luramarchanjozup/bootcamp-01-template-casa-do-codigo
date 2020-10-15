package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.Unique;
import br.com.carlos.casadocodigo.domain.entity.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class RequestEstadoDto {

    @NotBlank(message = "é obrigatorio") @Unique(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @Valid @NotNull
    private RequestPaisId pais;

    public Estado toEntity(EntityManager manager) {
        var pais = manager.find(Pais.class, this.pais.getId());
        return new Estado(nome, pais);
    }}
