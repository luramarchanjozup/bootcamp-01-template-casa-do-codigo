package br.com.casadocodigo.model;

import br.com.casadocodigo.validator.ExisteId;
import br.com.casadocodigo.validator.ValorUnico;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEstadoRequest {

    @NotBlank
    @ValorUnico(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    @ExisteId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public NovoEstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
        super();
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado toEstado(EntityManager entityManager){
        return new Estado(nome, entityManager.find(Pais.class, idPais));
    }

    @Override
    public String toString() {
        return "NovoEstadoRequest{" +
                "nome='" + nome + '\'' +
                ", idPais=" + idPais +
                '}';
    }
}
