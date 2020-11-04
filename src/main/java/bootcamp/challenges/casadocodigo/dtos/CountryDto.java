package bootcamp.challenges.casadocodigo.dtos;

import bootcamp.challenges.casadocodigo.entities.Country;
import bootcamp.challenges.casadocodigo.validators.EntityValueExists;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class CountryDto {
    @NotBlank
    @EntityValueExists(entityClass = Country.class, entityFieldName = "name", message = "já existe e não pode ser duplicado.")
    private final String name;

    public CountryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Country toModel(){
        return new Country(name);
    }

    public CategoryDto fromModel(Long id, EntityManager entityManager){
        Country country = entityManager.find(Country.class, id);
        return new CategoryDto(country.getName());
    }
}
