package br.com.carlos.casadocodigo.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ResponseEstadoDto {
    private String nome;
    @JsonInclude(Include.NON_NULL)
    private ResponsePaisId pais;

    public ResponseEstadoDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ResponsePaisId getPais() {
        return pais;
    }

    public void setPais(ResponsePaisId pais) {
        this.pais = pais;
    }
}
