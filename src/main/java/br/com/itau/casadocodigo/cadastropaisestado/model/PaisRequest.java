package br.com.itau.casadocodigo.cadastropaisestado.model;

import br.com.itau.casadocodigo.validador.AtributoUnico;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @AtributoUnico(nomeDoAtributo = "pais", classeDeDominio = Pais.class)
    private String pais;

    public String getPais() {
        return pais;
    }

    public Pais toModel() {
        return new Pais(this.pais);
    }
}
