package br.com.ecommerce.cdc.domain.model;

import br.com.ecommerce.cdc.anotacao.NotDuplicated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pais")
public class Pais {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

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
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
