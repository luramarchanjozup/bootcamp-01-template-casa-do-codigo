package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Categoria;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.annotation.ObjetoUnico;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @ObjetoUnico(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public NovaCategoriaRequest(){

    }

    public NovaCategoriaRequest(@NotBlank String nome){
        this.nome = nome;
    }

    public Categoria toModel(){
        return new Categoria(this.nome);
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toLowerCase();
    }
}
