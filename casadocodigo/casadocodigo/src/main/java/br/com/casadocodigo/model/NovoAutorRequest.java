package br.com.casadocodigo.model;


import br.com.casadocodigo.validator.ValorUnico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @ValorUnico(domainClass = Autor.class, fieldName = "email", message = "o email deve ser único")
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public Autor toAutor() {
        return new Autor(this.nome,this.email, this.descricao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
