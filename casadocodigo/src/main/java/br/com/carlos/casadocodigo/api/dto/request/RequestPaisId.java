package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.ExistsById;
import br.com.carlos.casadocodigo.domain.entity.Pais;

import javax.validation.constraints.NotNull;

public class RequestPaisId {
    @NotNull(message = "é obrigatorio") @ExistsById(domainClass = Pais.class, fieldName = "id")
    private Long id;

    public RequestPaisId() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
