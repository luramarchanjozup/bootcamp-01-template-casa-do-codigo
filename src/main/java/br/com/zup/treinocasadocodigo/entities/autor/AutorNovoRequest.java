package br.com.zup.treinocasadocodigo.entities.autor;

import br.com.zup.treinocasadocodigo.validators.uniquevalue.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Contagem de carga intrínseca da classe: 2
 */

public class AutorNovoRequest {
    @Email
    @NotBlank
    //1
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
