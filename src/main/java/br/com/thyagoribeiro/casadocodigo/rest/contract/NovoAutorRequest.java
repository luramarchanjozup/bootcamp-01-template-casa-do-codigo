package br.com.thyagoribeiro.casadocodigo.rest.contract;

import br.com.thyagoribeiro.casadocodigo.domain.Autor;
import br.com.thyagoribeiro.casadocodigo.validator.ExistsValue;
import br.com.thyagoribeiro.casadocodigo.validator.ValueStatus;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// CDD - Total: 2

public class NovoAutorRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @ExistsValue(domainClass = Autor.class, fieldName = "email", valueStatus = ValueStatus.NOT_EXISTS) // CDD 2 - Interface UniqueValue e classe Autor
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    @Deprecated
    public NovoAutorRequest() {
    }

    public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
