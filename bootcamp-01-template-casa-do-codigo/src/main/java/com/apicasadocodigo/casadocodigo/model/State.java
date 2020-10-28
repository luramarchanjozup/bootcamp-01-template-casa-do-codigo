package com.apicasadocodigo.casadocodigo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class State {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    //@UniqueValue(entity = State.class, attributeName = "name")
    private String name;

    @ManyToOne
    //@UniqueValue(entity = Country.class, attributeName = "id")
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "state", fetch = FetchType.LAZY)
    private List<City> cities = new ArrayList<>();

    @Deprecated
    public State() {

    }

    /*Observação: um estado nasce com seu nome e o país ao qual pertence, mas as cidades
    * são criadas com o tempo, ou seja, cidades nascem após um estado existir.
    * Também elemina a necessidade de gets e sets para a lista de cidades*/
    @Deprecated
    public State(Long id, @NotEmpty @NotNull String name, Country country, List<City> cities) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.cities = cities;
    }

    public State(@NotEmpty @NotNull String name, @NotNull Country country) {
        this.name = name;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(id, state.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
