package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation.ObjetoUnico;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "t_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nome;

    @Deprecated
    public Categoria(){

    }

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toLowerCase();
    }

    @Override
    public String toString() {
        return "Categoria criada: [" +
                "Nome: '" + nome + '\'' +
                ']';
    }
}
