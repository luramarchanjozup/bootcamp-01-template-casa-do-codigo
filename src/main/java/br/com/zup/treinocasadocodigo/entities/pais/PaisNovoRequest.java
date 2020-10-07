package br.com.zup.treinocasadocodigo.entities.pais;

import br.com.zup.treinocasadocodigo.validators.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisNovoRequest {

    @NotBlank
    @UniqueValue(dominioClasse = Pais.class, nomeCampo = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }
}
