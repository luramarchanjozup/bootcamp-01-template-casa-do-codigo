package com.bootcamp.cdd.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.function.Function;

@Entity
public class Shopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "O email deve ser preenchido")
    @Email(message = "O email foi preenchido de forma incorreta")
    private String email;
    @NotBlank(message = "O nome deve ser preenchido")
    private String nome;
    @NotBlank(message = "O sobrenome deve ser preenchido")
    private String sobrenome;
    @NotBlank(message = "O documento deve ser preenchido")
    private String documento;
    @NotBlank(message = "O endereco deve ser preenchido")
    private String endereco;
    @NotBlank(message = "O complemento deve ser preenchido")
    private String complemento;
    @NotBlank(message = "A cidade deve ser preenchido")
    private String cidade;
    @ManyToOne
    private State estado;
    @ManyToOne
    private Country pais;
    @NotBlank(message = "O telefone deve ser preenchido")
    private String telefone;
    @NotBlank(message = "O cep deve ser preenchido")
    private String cep;
    @OneToOne(mappedBy = "compra",cascade = CascadeType.ALL)
    private Pedido pedido;

    public Shopping(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, String telefone, String cep, Function<Shopping, Pedido> shoppingPedidoFunction  ) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = shoppingPedidoFunction.apply(this);
    }

    public void setEstado(State estado) {
        this.estado = estado;
    }

    public void setPais(Country pais) {
        this.pais = pais;
    }

    public long getId() {
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

    public String getDocumento() {
        return documento;
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

    public State getEstado() {
        return estado;
    }

    public Country getPais() {
        return pais;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Pedido getPedido() {
        return pedido;
    }
}
