package io.github.evertoncnsouza.domain.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pais {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotBlank
   private String nome;

   @OneToMany(mappedBy = "pais")
   @LazyCollection(LazyCollectionOption.EXTRA)
   private Set<Estado> estados;

   @Deprecated
   public Pais() {
   }

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }



    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
    public boolean possuiEstados() {
        return this.estados.size() != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pais)) return false;
        Pais pais = (Pais) o;
        return Objects.equals(getNome(), pais.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }
}
