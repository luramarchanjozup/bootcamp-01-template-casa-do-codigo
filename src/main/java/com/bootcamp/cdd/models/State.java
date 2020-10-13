package com.bootcamp.cdd.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "O nome do estado deve ser preenchido")
    private String name;
    @ManyToOne
    private Country country;

    public State(@NotBlank(message = "O nome do estado deve ser preenchido") String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public State() {
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public long getCountryId() {
        return getCountry().getId();
    }

    public long getId() {
        return id;
    }
}
