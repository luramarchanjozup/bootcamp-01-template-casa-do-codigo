package bootcamp.challenges.casadocodigo.dtos;

import bootcamp.challenges.casadocodigo.entities.Country;
import bootcamp.challenges.casadocodigo.entities.State;
import bootcamp.challenges.casadocodigo.validators.EntityValueExists;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StateDto {
    @NotBlank
    @EntityValueExists(entityClass = State.class, entityFieldName = "name", message = "já existe e não pode ser duplicado.")
    private final String name;
    @NotNull
    @EntityValueExists(entityClass = Country.class, entityFieldName = "id", expectedAssertion = true, message = "ainda não existe.")
    private final Long countryId;

    public StateDto(@NotBlank String name, @NotNull Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public State toModel(EntityManager entityManager){
        @NotNull Country country = entityManager.find(Country.class, countryId);
        return new State(name, country);
    }

    public StateDto fromModel(Long id, EntityManager entityManager){
        State state = entityManager.find(State.class, id);
        return new StateDto(state.getName(),state.getCountry().getId());
    }
}
