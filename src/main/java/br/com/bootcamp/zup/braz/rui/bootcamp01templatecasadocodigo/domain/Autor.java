package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation.ObjetoUnico;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;
    @NotNull
    private LocalDateTime registro = LocalDateTime.now();

    @Deprecated
    public Autor(){

    }

    public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return "Autor Cadastrado [" +
                "Nome: '" + nome + '\'' +
                " | Email: '" + email + '\'' +
                " | Descrição: '" + descricao + '\'' +
                ']';
    }
}