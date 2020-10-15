package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.Unique;
import br.com.carlos.casadocodigo.domain.entity.Pais;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class RequestPaisDto {

    @NotBlank @Unique(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public RequestPaisDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
