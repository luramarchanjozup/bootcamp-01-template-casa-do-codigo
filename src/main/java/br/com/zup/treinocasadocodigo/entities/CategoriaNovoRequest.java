package br.com.zup.treinocasadocodigo.entities;

import javax.validation.constraints.NotBlank;

/**
 * Contagem de carga intrínseca da classe: 1
 */

public class CategoriaNovoRequest {

    @NotBlank
    private String nome;

    public  CategoriaNovoRequest(){}

    public CategoriaNovoRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //1
    public Categoria toModel(){
        return new Categoria(this.nome);
    }
}
