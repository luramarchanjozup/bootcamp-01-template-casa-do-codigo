package br.com.zup.treinocasadocodigo.entities.pais;

import br.com.zup.treinocasadocodigo.validators.uniquevalue.UniqueValue;

import javax.validation.constraints.NotBlank;

/**
 * Contagem de carga intrínseca da classe: 2
 */

public class PaisNovoRequest {

    @NotBlank
    //1
    @UniqueValue(dominioClasse = Pais.class, nomeCampo = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    //1
    public Pais toModel() {
        return new Pais(this.nome);
    }
}
