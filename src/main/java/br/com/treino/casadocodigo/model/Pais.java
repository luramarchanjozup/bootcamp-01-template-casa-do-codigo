package br.com.treino.casadocodigo.model;

import br.com.treino.casadocodigo.validations.UniqueValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private @NotBlank String nome;

    public Pais(){}

    public Pais( @NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pais)) return false;
        Pais pais = (Pais) o;
        return getNome().equals(pais.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }


}
