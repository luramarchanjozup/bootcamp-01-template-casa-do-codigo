package br.com.itau.casadocodigo.novoautor.model;

import br.com.itau.casadocodigo.validador.AtributoUnico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private String nome;
    @AtributoUnico(nomeDoAtributo = "email", classeDeDominio = Autor.class) //Deve-se anotar o nome da variável com a anotação e sua classe de domínio
    @Email
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor toModel(){
        return new Autor(this.nome, this.email, this.descricao);
    }
}
