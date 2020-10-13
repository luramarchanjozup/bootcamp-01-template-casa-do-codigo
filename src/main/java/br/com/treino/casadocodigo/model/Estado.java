package br.com.treino.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private @NotBlank String nome;
    private @ManyToOne @NotNull Pais pais; //1

    public Estado(){}

    public Estado(@NotBlank String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() { return nome; }

    public Boolean perteceAoPais(Pais pais){
        return this.pais.equals(pais);
    }

}
