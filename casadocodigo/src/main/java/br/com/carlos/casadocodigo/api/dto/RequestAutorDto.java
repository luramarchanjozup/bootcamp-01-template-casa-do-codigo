package br.com.carlos.casadocodigo.api.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
public class RequestAutorDto {

    @NotBlank
    private String nome;

    @NotBlank @Email(message = "inválido")
    private String email;

    @NotBlank @Size(max = 400, message = "Limite de 400 carateres")
    private String descricao;

}
