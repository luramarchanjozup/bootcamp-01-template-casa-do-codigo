package io.github.evertoncnsouza.rest.dto;

import io.github.evertoncnsouza.domain.entity.Estado;
import io.github.evertoncnsouza.domain.entity.Pais;
import io.github.evertoncnsouza.validation.constraint.valitation.ExistsId;
import io.github.evertoncnsouza.validation.constraint.valitation.UniqueValue;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//1 PCI
public class EstadoRequest {

  @NotBlank
  @UniqueValue(domainClass = Estado.class, fieldName = "nome")
  private String nome;

  @NotNull
  @ExistsId(domainClass = Pais.class, fieldName = "id")
  private Long idPais;
  //PCI 1;

    public EstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
        super();
        this.nome = nome;
        this.idPais = idPais;
    }


    public Estado toModel(EntityManager manager) {
        return new Estado(nome, manager.find(Pais.class, idPais));
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idPais=" + idPais +
                '}';
    }


}
