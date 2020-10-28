package com.apicasadocodigo.casadocodigo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    private String name;

    @JsonIgnore
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_address_id")
    private State state;
    
    @Deprecated
    public City(){}

    @Deprecated
    public City(Long id, @NotEmpty @NotNull String name, @NotNull State state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public City(@NotEmpty @NotNull String name, @NotNull State state) {
        this.name = name;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }


    @JsonIgnore
    public Long getStateId(){
        return state.getId();
    }

    @JsonIgnore
    public Long getCountryId(){
        return state.getCountry().getId();
    }

    @JsonIgnore
    public String getCountryName(){
        return this.state.getCountry().getName();
    }

    @JsonIgnore
    public String getStateyName(){
        return this.state.getName();
    }

    @JsonIgnore
    public Country getCountry(){
        return this.state.getCountry();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
