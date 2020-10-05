package br.com.zup.treinocasadocodigo.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Contagem de carga intrínseca da classe: 1
 */

public class AutorNovoRequest {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    @Size(max=400)
    private String descricao;

    public AutorNovoRequest(@Email @NotBlank String email, @NotBlank String nome, @NotBlank @Size(max = 400) String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

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
