package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.ExistsById;
import br.com.carlos.casadocodigo.domain.entity.Categoria;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Transactional
public class RequestCategoriaId {
    @NotNull(message = "é obrigatorio") @ExistsById(domainClass = Categoria.class, fieldName = "id")
    private Long id;

    public RequestCategoriaId(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
