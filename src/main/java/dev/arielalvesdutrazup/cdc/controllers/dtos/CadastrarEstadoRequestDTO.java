package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.entities.Estado;

import javax.validation.constraints.NotBlank;

// 1 Estado.java
public class CadastrarEstadoRequestDTO {

    @NotBlank(message = "{nome.notempty}")
    private String nome;
    @NotBlank(message = "{codigo.notempty}")
    private String codigo;

    public CadastrarEstadoRequestDTO() {
    }

    public String getNome() {
        return nome;
    }

    public CadastrarEstadoRequestDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public CadastrarEstadoRequestDTO setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public Estado paraEntidade() {
        return new Estado()
                .setNome(nome)
                .setCodigo(codigo);
    }
}
