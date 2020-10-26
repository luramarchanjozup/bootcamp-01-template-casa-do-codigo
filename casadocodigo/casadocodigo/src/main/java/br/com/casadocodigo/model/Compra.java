package br.com.casadocodigo.model;

import br.com.casadocodigo.validator.CpfCnpj;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.function.Function;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CpfCnpj
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ManyToOne
    private Pais pais;

    @NotNull
    @ManyToOne
    private Estado estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @NotNull
    @Valid
    @OneToOne(mappedBy = "compra",cascade = CascadeType.PERSIST)
    private Pedido pedido;

    @Embedded
    private CupomAplicado cupomAplicado;

    public Compra(@Email @NotBlank String email, @NotBlank String nome,
                  @NotBlank String sobrenome, @NotBlank String documento,
                  @NotBlank String endereco, @NotBlank String complemento,
                  @NotNull Pais pais, @NotBlank String telefone,
                  @NotBlank String cep, Function<Compra, Pedido> funcaoCriacaoPedido) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = funcaoCriacaoPedido.apply(this);

    }

    public void setEstado(@NotNull @Valid Estado estado) {
        this.estado = estado;
    }

    public void aplicaCupom(Cupom cupom) {
        this.cupomAplicado = new CupomAplicado(cupom);
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pais=" + pais +
                ", estado=" + estado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", pedido=" + pedido +
                ", cupomAplicado=" + cupomAplicado +
                '}';
    }
}
