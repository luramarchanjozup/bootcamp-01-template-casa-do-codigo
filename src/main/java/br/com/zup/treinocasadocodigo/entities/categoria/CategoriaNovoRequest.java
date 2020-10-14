package br.com.zup.treinocasadocodigo.entities.categoria;

import br.com.zup.treinocasadocodigo.validators.uniquevalue.UniqueValue;

import javax.validation.constraints.NotBlank;

/**
 * Contagem de carga intrínseca da classe: 2
 */

public class CategoriaNovoRequest {

    @NotBlank
    //1
    @UniqueValue(dominioClasse = Categoria.class, nomeCampo = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    //1
    public Categoria toModel(){
        return new Categoria(this.nome);
    }
}
