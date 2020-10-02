package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotEmpty(message = "Preenchimento obrigatório.")
    private String nome;
    @NotEmpty(message = "Preenchimento obrigatório.")
    @Column(unique = true)
    @Email(message = "Formado de email inválido")
    private String email;
    @Length(max = 400)
    private String descricao;

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

}
