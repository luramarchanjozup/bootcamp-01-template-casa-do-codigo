package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Autor;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.annotation.ObjetoUnico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

    @NotBlank(message = "Preenchimento obrigatório.")
    private String nome;
    @NotBlank(message = "Preenchimento obrigatório.")
    @Email(message = "Formado de email inválido")
    @ObjetoUnico(domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotBlank(message = "Preenchimento obrigatório.")
    @Size(max = 400)
    private String descricao;

    public NovoAutorRequest(@NotBlank(message = "Preenchimento obrigatório.") String nome, @NotBlank(message = "Preenchimento obrigatório.") String email, @NotBlank(message = "Preenchimento obrigatório.") @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }

    //Getters e Setters
    public String getEmail() {
        return email;
    }


}
