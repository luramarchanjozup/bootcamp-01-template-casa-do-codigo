package br.com.carlos.casadocodigo.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
public class ResponseEstadoDto {
    private String nome;
    @JsonInclude(Include.NON_NULL)
    private ResponsePaisId pais;
}
