package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.Unique;
import br.com.carlos.casadocodigo.domain.entity.Categoria;
import javax.validation.constraints.NotBlank;


public class RequestCategoriaDto {

    @NotBlank @Unique(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public RequestCategoriaDto() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
