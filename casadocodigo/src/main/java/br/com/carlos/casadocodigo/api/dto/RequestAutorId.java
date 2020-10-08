package br.com.carlos.casadocodigo.api.dto;

import br.com.carlos.casadocodigo.api.handler.ExistsById;
import br.com.carlos.casadocodigo.domain.entity.Autor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RequestAutorId {
    @NotNull(message = "é obrigatorio") @ExistsById(domainClass = Autor.class, fieldName = "id")
    private Long id;

}
