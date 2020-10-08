package br.com.carlos.casadocodigo.api.dto;

import br.com.carlos.casadocodigo.api.handler.ExistsById;
import br.com.carlos.casadocodigo.domain.entity.Estado;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RequestEstadoId {
    @ExistsById(domainClass = Estado.class, fieldName = "id")
    private Long id;
}
