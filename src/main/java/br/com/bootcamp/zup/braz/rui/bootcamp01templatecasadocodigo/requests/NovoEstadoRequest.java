package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.annotation.ObjetoValido;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Estado;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Pais;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.annotation.ObjetoUnico;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEstadoRequest {

    @NotBlank
    @ObjetoUnico(domainClass = Estado.class, fieldName = "nome")
    private String nome;
    @NotNull
    @ObjetoValido(fieldName = "id", domainClass = Pais.class)
    private Integer idPais;

    @Deprecated
    public NovoEstadoRequest(){

    }

    public NovoEstadoRequest(@NotBlank String nome, @NotNull Integer idPais){
        this.nome = nome;
        this.idPais = idPais;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toLowerCase();
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public Estado toModel(EntityManager entityManager) {

        return new Estado(nome, entityManager.find(Pais.class, idPais));
    }
}
