package br.com.treino.casadocodigo.request;

import br.com.treino.casadocodigo.model.Autor;
import br.com.treino.casadocodigo.validations.UniqueValue;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

    private @NotBlank String nome;
    @UniqueValue(className = Autor.class, fieldName = "email",
            message = "Esse email já existe no banco de dados")
    private @NotBlank @Email String email;
    private @NotBlank @Size(max = 400) String descricao;

    public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email,
                            @NotBlank @Size(max = 400) String descricao) {
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
