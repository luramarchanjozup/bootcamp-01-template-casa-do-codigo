package br.com.zup.bootcamp.domain.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

// Intrinsic charge = 3
@Entity
public class Buyer implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String document;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String complement;

    @Column(nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    private State state;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private Country country;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String cep;

    @OneToOne(mappedBy = "buyer", cascade = CascadeType.ALL)
    private Purchase purchase;

    public Buyer(){}

    public Buyer(@Email @NotBlank String email, @NotBlank String name, @NotBlank String lastname,
                 @NotBlank String document, @NotBlank String address, @NotBlank String complement, @NotBlank String city,
                 State state, @NonNull Country country, @NotBlank String phone, @NotBlank String cep) {
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.country = country;
        this.phone = phone;
        this.cep = cep;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDocument() {
        return document;
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

    public State getState() {
        return state;
    }

    public Country getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}