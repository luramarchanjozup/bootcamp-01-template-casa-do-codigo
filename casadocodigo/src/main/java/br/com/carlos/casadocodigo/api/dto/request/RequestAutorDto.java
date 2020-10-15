package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.Unique;
import br.com.carlos.casadocodigo.domain.entity.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RequestAutorDto {

    @NotBlank(message = "é obrigatorio")
    private String nome;

    @NotBlank(message = "é obrigatorio") @Email(message = "inválido")
    @Unique(domainClass = Autor.class, fieldName = "email")
    private String email;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    @NotBlank(message = "é obrigatorio") @Size(max = 400, message = "Limite de 400 carateres")
    private String descricao;

}
