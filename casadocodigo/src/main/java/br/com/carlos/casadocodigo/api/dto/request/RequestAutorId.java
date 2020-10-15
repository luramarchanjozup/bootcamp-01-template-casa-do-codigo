package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.ExistsById;
import br.com.carlos.casadocodigo.domain.entity.Autor;

import javax.validation.constraints.NotNull;

public class RequestAutorId {
    @NotNull(message = "é obrigatorio") @ExistsById(domainClass = Autor.class, fieldName = "id")
    private Long id;

    public RequestAutorId() {}

    public Long getId() {
        return id;
    }
}
