package br.com.zup.bootcamp.domain.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Collection;

// Intrinsic charge = 2
@Entity
public class Country implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "country")
    private Collection<State> states;

    @OneToMany(mappedBy = "country")
    private Collection<Buyer> buyers;

    public Country(){}

    public Country(@NotBlank String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Buyer> getBuyers() {
        return buyers;
    }

    public Collection<State> getStates() {
        return states;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStates(Collection<State> states) {
        this.states = states;
    }

    public void addBuyer(Buyer buyer){
        this.buyers.add(buyer);
    }
}
