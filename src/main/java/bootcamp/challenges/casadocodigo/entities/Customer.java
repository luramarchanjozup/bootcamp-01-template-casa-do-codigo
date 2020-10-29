package bootcamp.challenges.casadocodigo.entities;

import bootcamp.challenges.casadocodigo.validators.CpfCnpj;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// Total Intrinsic Load Points: 2
@Embeddable
public class Customer {
    @NotBlank
    @Column(nullable = false)
    private String name;
    @NotBlank
    @Column(nullable = false)
    private String surname;
    @NotBlank
    @Email
    @Column(nullable = false)
    private String email;
    @NotNull
    @CpfCnpj
    @Column(nullable = false)
    private String personId;
    @NotBlank
    private String address;
    @NotBlank
    private String complement;
    @NotBlank
    private String city;
    @NotNull
    @ManyToOne
    private Country country; // 1 - Country
    @ManyToOne
    private State state; // 1 - State
    @NotNull
    @Column(nullable = false)
    private Long telephone;
    @NotNull
    @Column(nullable = false)
    private Long cep;

    @Deprecated
    public Customer() {}

    public Customer(@NotBlank String name,
                    @NotBlank String surname,
                    @NotBlank @Email String email,
                    @NotBlank String personId,
                    @NotBlank String address,
                    @NotBlank String complement,
                    @NotBlank String city,
                    @NotBlank Country country,
                    State state,
                    @NotBlank Long telephone,
                    @NotBlank Long cep) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.personId = personId;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.state = state;
        this.telephone = telephone;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Costumer{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", personId=" + personId +
                ", country=" + country +
                ", state=" + state +
                ", telephone=" + telephone +
                ", cep=" + cep +
                '}';
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

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public Long getTelephone() {
        return telephone;
    }

    public Long getCep() {
        return cep;
    }
}
