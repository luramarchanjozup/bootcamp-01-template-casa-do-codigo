package com.bootcamp.cdd.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private final String name;

    public Category (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
