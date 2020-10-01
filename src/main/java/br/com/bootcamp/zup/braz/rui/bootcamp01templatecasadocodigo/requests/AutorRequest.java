package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests;

import com.sun.istack.NotNull;

public class AutorRequest {

    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private String descricao;

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

}
