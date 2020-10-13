package io.github.evertoncnsouza.domain.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "pais")
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

    @Override //Detalhado o passo a passo na classe livro;
    public int hashCode() {
       final int prime = 31;
       int result = 1;
       result = prime * result + ((nome ==null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
       if (this == obj)
           return true;
       if (obj == null)
           return false;
       if (getClass() != obj.getClass())
           return false;
       Pais other = (Pais) obj;
       if (nome == null) {
           if (other.nome != null)
               return false;
       } else if (!nome.equals(other.nome))
           return false;
       return true;
   }
}
