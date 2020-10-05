package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.services.validation.EmailDuplicado;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;

public class NovoAutorRequest {

    @NotEmpty(message = "Preenchimento obrigatório.")
    private String nome;
    @NotEmpty(message = "Preenchimento obrigatório.")
    @Column(unique = true)
    @Email(message = "Formado de email inválido")
    @EmailDuplicado
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
