package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.annotations.ExistsValue;
import br.com.zup.casadocodigo.annotations.UniqueValue;
import br.com.zup.casadocodigo.domain.Country;
import br.com.zup.casadocodigo.domain.State;
import br.com.zup.casadocodigo.domain.Buyer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BuyerDTO {

    @NotBlank(message = "is required")
    private String name;

    @NotBlank(message = "is required")
    private String surname;

    @NotBlank(message = "is required") @Email(message = "Invalid email address")
    @UniqueValue(domainClass = Buyer.class, fieldName = "email", message = "already registered")
    private String email;

    @NotBlank(message = "is required")
    private String cpfCnpj;

    @NotBlank(message = "is required")
    private String address;

    @NotBlank(message = "is required")
    private String complement;

    @NotBlank(message = "is required")
    private String city;

    @NotNull(message = "is required")
    @ExistsValue(domainClass = Country.class, fieldName = "id", message = "the country does not exist")
    private Long countryId;

    //@NotBlank(message = "is required")
    @ExistsValue(domainClass = State.class, fieldName = "id", message = "the state does not exist")
    private Long stateId;

    @NotBlank(message = "is required")
    private String phone;

    @NotBlank(message = "is required")
    private String zipCode;

    public BuyerDTO(@NotBlank String name, @NotBlank String surname,
                    @NotBlank @Email String email,
                    @NotBlank String cpfCnpj,
                    @NotBlank String address,
                    @NotBlank String complement,
                    @NotBlank String city,
                    @NotNull Long countryId,
                    Long stateId,
                    @NotBlank String phone,
                    @NotBlank String zipCode) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.countryId = countryId;
        this.stateId = stateId;
        this.phone = phone;
        this.zipCode = zipCode;
    }

    public boolean validatesCpfCnpj() {
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(cpfCnpj, null) || cnpjValidator.isValid(cpfCnpj, null);
    }

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public Buyer toModel(EntityManager manager) {
        Country country = manager.find(Country.class, countryId);

        Buyer buyer = new Buyer(this.name, this.surname, this.email, this.cpfCnpj,
        this.address, this.complement, this.city, country, this.phone, this.zipCode);

        if(stateId != null) {
            buyer.setState(manager.find(State.class, stateId));
        }

        return buyer;
    }
}
