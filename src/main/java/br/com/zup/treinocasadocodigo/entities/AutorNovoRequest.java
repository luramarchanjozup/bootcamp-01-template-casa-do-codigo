package br.com.zup.treinocasadocodigo.entities;

import br.com.zup.treinocasadocodigo.validators.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Contagem de carga intrínseca da classe: 1
 */

public class AutorNovoRequest {
    @Email
    @NotBlank
    @UniqueValue(dominioClasse = Autor.class, nomeCampo = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    @Size(max=400)
    private String descricao;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    //1
    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }

}
