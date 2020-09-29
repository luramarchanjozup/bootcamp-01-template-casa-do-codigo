package com.github.marcoscoutozup.casadocodigo.autor;

import com.github.marcoscoutozup.casadocodigo.validator.unique.Unique;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDTO {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @Unique(campo = "email", classe = Autor.class)
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

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

    public Autor toModel(){
        return new Autor(nome, email, descricao);
    }
}
