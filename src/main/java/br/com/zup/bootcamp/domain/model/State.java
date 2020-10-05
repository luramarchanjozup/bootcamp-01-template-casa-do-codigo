package br.com.zup.bootcamp.domain.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Collection;

// Intrinsic charge = 2
@Entity
public class State implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Country country;

    @OneToMany
    private Collection<Buyer> buyers;

    public State(){}

    public State(@NotBlank Country country, @NotBlank String name) {
        this.country = country;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Country getCountry() {
        return country;
    }

    public Collection<Buyer> getBuyers() {
        return buyers;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void addBuyer(Buyer buyer){
        this.buyers.add(buyer);
    }
}
