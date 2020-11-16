package br.com.casadocodigo.models;

import br.com.casadocodigo.validation.Unique;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    /*  pontos de dificuldade de entendimento =  1 */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    /* @complexidade (1) - acoplamento contextual */
    @OneToMany(mappedBy = "category")
    private Set<Book> books = new HashSet<>();

    @Deprecated
    public Category(){};

    public Category(String name){
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }
}
