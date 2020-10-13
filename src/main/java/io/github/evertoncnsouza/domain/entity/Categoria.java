package io.github.evertoncnsouza.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

//Não tem PCI
@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{nome.categoria.obrigatorio}")
    @Column(unique = true)
    private String nome;

    @Deprecated
    public Categoria(){
    };

    public Categoria(@NotEmpty(message = "{nome.categoria.obrigatorio}") String nome)
    {
        this.nome = nome;
    }

    @Override //Tirei a palavra "categoria para não quebrar o Json;
    public String toString() {
        return "{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
