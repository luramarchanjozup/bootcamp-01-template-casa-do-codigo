package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.ExistsById;
import br.com.carlos.casadocodigo.domain.entity.Estado;
;

public class RequestEstadoId {
    @ExistsById(domainClass = Estado.class, fieldName = "id")
    private Long id;

    public RequestEstadoId() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
