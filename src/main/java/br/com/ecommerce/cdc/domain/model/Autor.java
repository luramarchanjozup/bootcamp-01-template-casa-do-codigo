package br.com.ecommerce.cdc.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

/**
 * Carga Intrínseca máxima permitida - 9
 * Carga Intrínseca da classe - 0
 *
 */

@Entity
@Table(name = "autor")
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(max = 400)
    private String descricao;
    @NotNull
    private LocalDateTime instante;

    public Autor() {
    }

    public Autor(@NotBlank String nome, @NotBlank String email, @NotBlank @Max(400) String descricao, @NotNull LocalDateTime instante) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.instante = instante;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public Long id(){
        return getId();
    }

    public String nome(){
        return getNome();
    }

    public String email(){
        return getEmail();
    }

    public String descricao(){
        return getDescricao();
    }

    public LocalDateTime momento(){
        return getInstante();
    }
}
