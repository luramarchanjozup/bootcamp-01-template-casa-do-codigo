package br.com.carlos.casadocodigo.api.dto;

import br.com.carlos.casadocodigo.api.handler.ExistsById;
import br.com.carlos.casadocodigo.domain.entity.Pais;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RequestPaisId {
    @NotNull(message = "é obrigatorio") @ExistsById(domainClass = Pais.class, fieldName = "id")
    private Long id;
}
