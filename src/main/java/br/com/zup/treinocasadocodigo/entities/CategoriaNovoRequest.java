package br.com.zup.treinocasadocodigo.entities;

import br.com.zup.treinocasadocodigo.validators.UniqueValue;

import javax.validation.constraints.NotBlank;

/**
 * Contagem de carga intrínseca da classe: 1
 */

public class CategoriaNovoRequest {

    @NotBlank
    @UniqueValue(dominioClasse = Categoria.class, nomeCampo = "nome")
    private String nome;

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
