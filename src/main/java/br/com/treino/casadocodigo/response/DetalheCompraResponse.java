package br.com.treino.casadocodigo.response;

import br.com.treino.casadocodigo.model.Compra;
import br.com.treino.casadocodigo.model.Estado;
import br.com.treino.casadocodigo.model.Pais;
import br.com.treino.casadocodigo.model.Pedido;
import br.com.treino.casadocodigo.validations.CpfOuCnpj;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

public class DetalheCompraResponse {

    private String nome;
    private String sobrenome;
    private String email;
    private String documento;
    private String telefone;
    private Pais pais;
    private Estado estado;
    private String cidade;
    private String endereco;
    private String cep;
    private String complemento;
    private Pedido pedido; //1
    private CupomAplicado cupomAplicado; //2
    private BigDecimal totalComDesconto;

    public DetalheCompraResponse(Compra compra) {
        this.nome = compra.getNome();
        this.sobrenome = compra.getSobrenome();
        this.email = compra.getEmail();
        this.documento = compra.getDocumento();
        this.telefone = compra.getTelefone();
        this.pais = compra.getPais();
        this.estado = compra.getEstado();
        this.cidade = compra.getCidade();
        this.endereco = compra.getEndereco();
        this.cep = compra.getCep();
        this.complemento = compra.getComplemento();
        this.pedido = compra.getPedido();
        this.cupomAplicado = compra.getCupomAplicado();
        this.totalComDesconto = compra.getTotalComDesconto();
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public CupomAplicado getCupomAplicado() {
        return cupomAplicado;
    }

    public BigDecimal getTotalComDesconto() {
        return totalComDesconto;
    }
}
