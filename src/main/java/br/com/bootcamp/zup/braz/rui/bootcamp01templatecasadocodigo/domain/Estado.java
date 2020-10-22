package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String nome;

    @NotNull
    @Valid
    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @Deprecated
    public Estado(){

    }

    public Estado(@NotBlank String nome, @NotNull @Valid Pais pais) {
        this.nome = nome;
        this.pais = pais;
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
        this.nome = nome;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public boolean pertenceAPais(Pais pais){
        return this.pais.equals(pais);
    }
}
