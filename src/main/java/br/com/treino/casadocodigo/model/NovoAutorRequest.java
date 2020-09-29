package br.com.treino.casadocodigo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @NotBlank String nome;
    private @NotBlank @Email String email;
    private @NotBlank @Size(max = 400) String descricao;

    public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email,
                            @NotBlank @Size(max = 400) String descricao) {
        super();
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel(){
        return new Autor(this.nome, this.email, this.descricao);
    }

    public String getEmail(){
        return this.email;
    }


}
