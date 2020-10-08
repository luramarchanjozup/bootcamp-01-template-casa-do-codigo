package br.com.carlos.casadocodigo.api.dto;

import br.com.carlos.casadocodigo.api.handler.ExistsById;
import br.com.carlos.casadocodigo.domain.entity.Categoria;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RequestCategoriaId {
    @NotNull(message = "é obrigatorio") @ExistsById(domainClass = Categoria.class, fieldName = "id")
    private Long id;

}
