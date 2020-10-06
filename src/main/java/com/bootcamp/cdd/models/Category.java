package com.bootcamp.cdd.models;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Category (String name) {
        this.name = name;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

}
