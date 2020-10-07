package br.com.ecommerce.cdc.domain.request;

import br.com.ecommerce.cdc.anotacao.ExistInDataBase;
import br.com.ecommerce.cdc.anotacao.NotDuplicated;
import br.com.ecommerce.cdc.domain.model.Estado;
import br.com.ecommerce.cdc.domain.model.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

/**
 * Carga intrínseca máxima permitida - 9
 * Carga intrínseca da classe - 2
 */

public class EstadoRequest {

    @NotDuplicated(nameClass = "Estado", fieldName = "nome")
    private String nome;
    @NotNull @ExistInDataBase(nameClass = "Pais", nameFieldClass = Pais.class)
    private Long pais;

    public EstadoRequest() {
    }

    public EstadoRequest(String nome, @NotNull Long pais) {
        this.nome = nome;
        this.pais = pais;
    }

    // +1
    public Estado toModel(EntityManager manager){
        // +1
        Pais pais = manager.find(Pais.class, this.pais);

        return new Estado(this.nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return "EstadoRequest{" +
                "nome='" + nome + '\'' +
                ", pais=" + pais +
                '}';
    }
}
