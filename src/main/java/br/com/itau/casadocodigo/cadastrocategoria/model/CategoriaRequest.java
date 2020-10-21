package br.com.itau.casadocodigo.cadastrocategoria.model;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    private String nomeCategoria;

    @Deprecated
    public CategoriaRequest() {
    }

    public CategoriaRequest(@NotBlank String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
//1
    public Categoria toModel(){
        return new Categoria(this.nomeCategoria);
    }
}
