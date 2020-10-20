package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.annotations.ExistsValue;
import br.com.zup.casadocodigo.annotations.UniqueValue;
import br.com.zup.casadocodigo.domain.Category;
import br.com.zup.casadocodigo.domain.Country;
import br.com.zup.casadocodigo.domain.State;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StateDTO {

    @NotBlank
    @UniqueValue(domainClass = State.class, fieldName = "name", message = "already registered")
    private String name;

    @NotNull(message = "is required")
    @ExistsValue(domainClass = Country.class, fieldName = "id", message = "the country does not exist")
    private Long idCountry;

    public StateDTO(@NotBlank String name, @NotNull Long idCountry) {
        this.name = name;
        this.idCountry = idCountry;
    }

    public State toModel (EntityManager manager) {
        return new State(name, manager.find(Country.class, idCountry));
    }
}
