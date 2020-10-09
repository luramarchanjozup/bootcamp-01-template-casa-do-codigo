package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Pais;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation.ObjetoUnico;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    @ObjetoUnico(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public NovoPaisRequest(){

    }

    public NovoPaisRequest(@NotBlank String nome){
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(this.nome = nome);
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toLowerCase();
    }


}
