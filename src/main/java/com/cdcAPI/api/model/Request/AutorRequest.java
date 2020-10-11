package com.cdcAPI.api.model.Request;

import com.cdcAPI.model.Autor;
import com.cdcAPI.validator.EntradaUnica;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//Complexidade
//EntradaUnica, Autor
//Total = 2

public class AutorRequest {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @EntradaUnica(domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorRequest(@NotBlank String nome,
                            @NotBlank @Email String email,
                            @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome,this.email,this.descricao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    } //Apresentar msg de erro

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
