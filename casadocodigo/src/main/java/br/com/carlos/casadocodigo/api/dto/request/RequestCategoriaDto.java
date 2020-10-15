package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.Unique;
import br.com.carlos.casadocodigo.domain.entity.Categoria;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter @Setter
public class RequestCategoriaDto {

    @NotBlank @Unique(domainClass = Categoria.class, fieldName = "nome")
    private String nome;
}
