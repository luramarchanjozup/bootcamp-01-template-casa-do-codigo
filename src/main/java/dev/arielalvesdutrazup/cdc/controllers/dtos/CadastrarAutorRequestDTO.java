package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.Autor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// 1 Autor.java
public class CadastrarAutorRequestDTO {

    @NotBlank(message = "{nome.notempty}")
    private String nome;
    @Email(message = "{email.email}")
    @NotBlank(message = "{email.notempty}")
    private String email;
    @Column(columnDefinition = "TEXT")
    @Size(max = 400, message = "{descricao.max}")
    @NotBlank(message = "{descricao.notempty}")
    private String descricao;

    public String getNome() {
        return nome;
    }

    public CadastrarAutorRequestDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CadastrarAutorRequestDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public CadastrarAutorRequestDTO setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Autor paraEntidade() {
        return new Autor()
                .setNome(nome)
                .setEmail(email)
                .setDescricao(descricao);
    }
}
