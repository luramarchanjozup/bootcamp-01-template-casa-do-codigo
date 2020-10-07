package br.com.ecommerce.cdc.domain.model;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cadastro")
public class Cadastro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @Size(min = 11, max = 14)
    private String cpfOuCnpj;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @OneToOne
    private Pais pais;
    @NotNull
    @OneToOne
    private Estado estado;
    @NotBlank @PositiveOrZero
    @Size(min = 8)
    private String telefone;
    @NotBlank
    @Size(min = 8, max = 14) @PositiveOrZero
    private String cep;

    public Cadastro() {
    }

    public Cadastro(Long id, @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank @Size(min = 11, max = 14) String cpfOuCnpj, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Pais pais, @NotNull Estado estado, @NotBlank @PositiveOrZero @Size(min = 8) String telefone, @NotBlank @Size(min = 8, max = 14) @PositiveOrZero String cep) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpfOuCnpj = cpfOuCnpj;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
