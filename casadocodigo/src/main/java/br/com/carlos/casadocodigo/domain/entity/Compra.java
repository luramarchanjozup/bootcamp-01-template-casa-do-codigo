package br.com.carlos.casadocodigo.domain.entity;


import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

@Entity
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email @NotBlank
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @ManyToOne @NotNull
    private Pais pais;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @ManyToOne
    private Estado estado;

    @OneToOne(mappedBy = "compra",cascade = CascadeType.PERSIST)
    private Pedido pedido;

    @Embedded
    private CupomAplicado cupomAplicado;

    @Deprecated
    public Compra(){}

    public Compra(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
                  String cidade, Pais pais, Estado estado, String telefone, String cep, Function<Compra,
                    Pedido> funcaoCriacaoPedido) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        setEstado(estado);
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = funcaoCriacaoPedido.apply(this);
    }

    public void setEstado(Estado estado) {
        Assert.notNull(pais,"Não foi possivel associar o estado, país nulo");
        Assert.isTrue(estado.pertenceAPais(pais),"Este estado não é do país associado a compra");
        this.estado = estado;
    }

    public void aplicaCupom(Cupom cupom) {
        Assert.isTrue(cupom.valido(),"Cupom está mais válido");
        Assert.isNull(cupomAplicado,"Não pode trocar um cupom de uma compra");
        this.cupomAplicado = new CupomAplicado(cupom);
    }
    public BigDecimal totalComDesconto(BigDecimal total){
        var desconto = total.multiply(this.cupomAplicado.getPercentualDescontoMomento().divide(BigDecimal.valueOf(100)));
        return (total.subtract(desconto)).setScale(2, RoundingMode.HALF_UP);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Estado getEstado() {
        return estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public CupomAplicado getCupomAplicado() {
        return cupomAplicado;
    }

    public void setCupomAplicado(CupomAplicado cupomAplicado) {
        this.cupomAplicado = cupomAplicado;
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
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", estado=" + estado +
                ", pedido=" + pedido +
                ", cupomAplicado=" + cupomAplicado +
                '}';
    }
}
