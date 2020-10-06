package com.github.marcoscoutozup.casadocodigo.estado;

import com.github.marcoscoutozup.casadocodigo.pais.Pais;
import com.github.marcoscoutozup.casadocodigo.validator.exists.Exists;
import com.github.marcoscoutozup.casadocodigo.validator.unique.Unique;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class EstadoDTO {

    @NotBlank
    @Unique(campo = "nome", classe = Estado.class)
    private String nome;

    @NotNull
    @Exists(classe = Pais.class)
    private UUID pais;

            //1
    public Estado toModel(){
        return new Estado(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getPais() {
        return pais;
    }

    public void setPais(UUID pais) {
        this.pais = pais;
    }
}
