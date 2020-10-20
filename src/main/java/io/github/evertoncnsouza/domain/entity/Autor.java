package io.github.evertoncnsouza.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

//Não tem PCI
@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{campo.email.obrigatorio}")
    @Email(message = "{email.invalido}")
    private String email;

    @Size (max = 400, message = "{limite.maximo.400}")
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @NotNull
    private LocalDateTime horaCriacao = LocalDateTime.now();

    //Construtor sem argumentos depreciado
    @Deprecated
    public Autor() {
    }

    //Informação obrigatória se passa no construtor.
    //Annotations para deixar dica no código;
    public Autor(@NotEmpty(message = "{campo.nome.obrigatorio}") String nome,
                 @NotEmpty(message = "{campo.email.obrigatorio}")
                 @Email(message = "{email.invalido}") String email,
                 @NotEmpty(message = "{campo.descricao.obrigatorio}") String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    //Cada getter e setter só são criados se necessário;
    // Get criado para a classe "DetalheSiteAutorResponse"
    public String getNome() {
        return nome;
    }

    //Get criado para a classe "DetalheSiteAutorResponse"
    public String getDescricao() {
        return descricao;
    }

    //Tirei a palavra "Autor" do método toString para não quebrar o Json;
    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", horaCriacao=" + horaCriacao +
                '}';
    }
}


