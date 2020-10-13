package com.example.apicasadocodigo.fluxocompra.compra;

import com.example.apicasadocodigo.fluxocompra.cupom.Cupom;
import com.example.apicasadocodigo.fluxocompra.cupom.CupomAplicado;
import com.example.apicasadocodigo.fluxocompra.pedido.Pedido;
import com.example.apicasadocodigo.localidade.Estado;
import com.example.apicasadocodigo.localidade.Pais;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.function.Function;

@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @Email @NotBlank String email;
    private @NotBlank String nome;
    private @NotBlank String sobrenome;
    private @NotBlank String documento;
    private @NotBlank String endereco;
    private @NotBlank String complemento;
    private @NotBlank String cidade;
    private @ManyToOne @NotNull Pais pais;
    private @ManyToOne Estado estado;
    private @NotBlank String telefone;
    private @NotBlank String cep;
    private @OneToOne(mappedBy = "compra", cascade = CascadeType.PERSIST) @NotNull @Valid Pedido pedido;
    private @Embedded
    CupomAplicado cupom;

    @Deprecated
    public Compra() {
    }

    public Compra(@Email @NotBlank String email, @NotBlank String nome,
                  @NotBlank String sobrenome, @NotBlank String documento,
                  @NotBlank String endereco, @NotBlank String complemento,
                  @NotBlank String cidade, @NotNull Pais pais,
                  @NotBlank String telefone, @NotBlank String cep,
                  Function<Compra, Pedido> funcaoCriacaoPedido) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = funcaoCriacaoPedido.apply(this);
    }

    public void aplicarCupom(Cupom cupom) {
        this.cupom = new CupomAplicado(cupom);
    }

    public BigDecimal total() {
        return pedido.calcularTotal();
    }

    public BigDecimal calcularTotalComDesconto() {
        BigDecimal desconto = cupom.getDesconto();
        return total().subtract(desconto.divide(new BigDecimal(100)).multiply(total()));
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public CupomAplicado getCupom() {
        return cupom;
    }

    public void setCupom(CupomAplicado cupom) {
        this.cupom = cupom;
    }
}