package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String nome;
    private String email;
    private String descricao;
    @NotNull
    private LocalDateTime registro;

    @Deprecated
    public Autor(){

    }

    public Autor(String nome, String email, String descricao, LocalDateTime registro) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.registro = registro;
    }


    //Getters e Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getRegistro() {
        return registro;
    }
}
