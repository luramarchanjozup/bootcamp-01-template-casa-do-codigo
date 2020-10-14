package br.com.ecommerce.cdc.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Carga Intrínseca máxima permitida - 9
 * Carga Intrínseca da classe - 0
 */

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    public Categoria() {
    }

    public Categoria(String nome) {
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
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
