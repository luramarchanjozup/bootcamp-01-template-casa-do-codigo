package bootcamp.challenges.casadocodigo.dtos;

import bootcamp.challenges.casadocodigo.entities.Customer;
import bootcamp.challenges.casadocodigo.entities.Country;
import bootcamp.challenges.casadocodigo.entities.State;
import bootcamp.challenges.casadocodigo.validators.CpfCnpj;
import bootcamp.challenges.casadocodigo.validators.EntityValueExists;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public final class CustomerDto {
    @NotBlank
    private final String name;
    @NotBlank
    private final String surname;
    @NotBlank
    @Email
    private final String email;
    @NotNull
    @CpfCnpj
    private final String personId;
    @NotBlank
    private final String address;
    @NotBlank
    private final String complement;
    @NotBlank
    private final String city;
    @NotNull
    @EntityValueExists(entityClass = Country.class, entityFieldName = "id", expectedAssertion = true, message = "não esixte ainda")
    private final Long countryId;
    @EntityValueExists(entityClass = State.class, entityFieldName = "id", expectedAssertion = true, message = "não existe ainda")
    private final Long stateId;
    @NotNull
    private final Long telephone;
    @NotNull
    private final Long cep;

    public CustomerDto(@NotBlank String name,
                       @NotBlank String surname,
                       @NotBlank @Email String email,
                       @NotBlank String personId,
                       @NotBlank String address,
                       @NotBlank String complement,
                       @NotBlank String city,
                       @NotBlank Long countryId,
                       Long stateId,
                       @NotBlank Long telephone,
                       @NotBlank Long cep) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.personId = personId;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.countryId = countryId;
        this.stateId = stateId;
        this.telephone = telephone;
        this.cep = cep;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPersonId() {
        return personId;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public Long getTelephone() {
        return telephone;
    }

    public Long getCep() {
        return cep;
    }
    public Customer toModel(EntityManager entityManager){
        @NotNull Country country = entityManager.find(Country.class, countryId);
        @NotNull State state = entityManager.find(State.class, stateId);
        return new Customer(name, surname, email, personId, address, complement, city, country, state, telephone,cep);
    }
}
