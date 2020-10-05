package com.bootcamp.cdd.models;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private final String name;

    public Category (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
