package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.Pais;

import javax.validation.constraints.NotBlank;

// 1 Pais.java
public class CadastrarPaisRequestDTO {

    @NotBlank(message = "{nome.notempty}")
    private String nome;
    @NotBlank(message = "{codigo.notempty}")
    private String codigo;

    public CadastrarPaisRequestDTO() {
    }

    public String getNome() {
        return nome;
    }

    public CadastrarPaisRequestDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public CadastrarPaisRequestDTO setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public Pais paraEntidade() {
        return new Pais()
                .setNome(nome)
                .setCodigo(codigo);
    }
}
