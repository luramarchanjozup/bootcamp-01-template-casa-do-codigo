package br.com.ecommerce.cdc.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * Carga Intrínseca máxima permitida - 9
 * Carga Intrínseca da classe - 4
 *
 */

@Entity
@Table(name = "compra")
public class Compra {
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
    @ManyToOne
    // +1
    private Pais pais;
    @NotNull
    @ManyToOne
    // +1
    private Estado estado;
    @NotBlank @PositiveOrZero
    @Size(min = 8)
    private String telefone;
    @NotBlank
    @Size(min = 8, max = 14)
    @PositiveOrZero
    private String cep;
    @Valid
    @OneToOne(mappedBy = "compra", cascade = CascadeType.PERSIST)
    // +1
    private CarrinhoCompra carrinhoCompra;

    @JsonIgnore
    @ManyToOne
    private CupomDesconto cupomDesconto;

    public Compra(@NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank @Size(min = 11, max = 14) String cpfOuCnpj, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Pais pais, @NotNull Estado estado, @NotBlank @PositiveOrZero @Size(min = 8) String telefone, @NotBlank @Size(min = 8, max = 14) @PositiveOrZero String cep, CarrinhoCompra carrinhoCompra) {
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
        this.carrinhoCompra=carrinhoCompra;
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

    public CarrinhoCompra getCarrinhoCompra() {
        return carrinhoCompra;
    }

    public CupomDesconto getCupomDesconto() {
        return cupomDesconto;
    }

    public void setCupomDesconto(CupomDesconto cupomDesconto) {
        this.cupomDesconto = cupomDesconto;
    }

    public void aplicaCupomDesconto(CupomDesconto cupomDesconto){
        setCupomDesconto(cupomDesconto);
    }

    public double getValorTotal(){
        return this.carrinhoCompra.getItens().stream()
                // +1
                .mapToDouble(itensPedido -> {
                    return itensPedido.getValorTotal().doubleValue();
                }).sum();
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cpfOuCnpj='" + cpfOuCnpj + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pais=" + pais +
                ", estado=" + estado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", carrinhoCompra=" + carrinhoCompra +
                '}';
    }
}
