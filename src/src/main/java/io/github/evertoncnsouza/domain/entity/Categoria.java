package io.github.evertoncnsouza.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

//Não tem PCI
@Entity
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

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
