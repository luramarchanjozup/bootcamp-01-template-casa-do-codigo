package io.github.evertoncnsouza.rest.dto;

import io.github.evertoncnsouza.domain.entity.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//Não tem PCI
//Classe criada para proteger a classe Autor, isolando parâmetros de domínio.
//Não é necessário @Entity, @Table e @Id;
    public class AutorRequest {

    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{campo.email.obrigatorio}")
    @Email(message = "{email.invalido}")
     private String email;

    @Size(max = 400, message = "{limite.maximo.400}")
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;


    public AutorRequest(@NotEmpty(message = "{campo.nome.obrigatorio}")
    String nome, @NotEmpty(message = "{campo.email.obrigatorio}")
    @Email(message = "{email.invalido}")
    String email, @Size(max = 400, message = "{limite.maximo.400}")
    @NotEmpty(message = "{campo.descricao.obrigatorio}") String descricao) {
        //Super() é para este construtor, chamar o construtor da classe mãe "Autor";
        super();
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
    //Para definir o modelo do Json que retornará na classe, "AutorController"
    public Autor toModel() {
        return new Autor(this.nome,this.email,this.descricao);
    }

    //Get criado para operação na classe "EmailValidator";
    public String getEmail() {
        return this.email;
    }
    }

