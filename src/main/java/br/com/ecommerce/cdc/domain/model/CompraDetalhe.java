package br.com.ecommerce.cdc.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.Optional;
/**
 * Carga intrínseca máxima permitida - 9
 * Carga intrínseca da classe - 6
 */
public class CompraDetalhe {

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
    // +1
    private Pais pais;
    @NotNull
    // +1
    private Estado estado;
    @NotBlank @PositiveOrZero
    @Size(min = 8)
    private String telefone;
    @NotBlank
    @Size(min = 8, max = 14)
    @PositiveOrZero
    private String cep;
    // +1
    private CarrinhoCompra carrinhoCompra;

    @JsonIgnore
    // +1
    private CupomDesconto cupomDesconto;
    // +1
    private ResumoCompra resumoCompra;

    public CompraDetalhe() {
    }
    // +1
    public CompraDetalhe(Compra compra){
        this.id = compra.getId();
        this.email = compra.getEmail();
        this.nome = compra.getNome();
        this.sobrenome = compra.getSobrenome();
        this.cpfOuCnpj = compra.getCpfOuCnpj();
        this.endereco = compra.getEndereco();
        this.complemento = compra.getComplemento();
        this.cidade = compra.getCidade();
        this.pais = compra.getPais();
        this.estado = compra.getEstado();
        this.telefone = compra.getTelefone();
        this.cep = compra.getCep();
        this.carrinhoCompra = compra.getCarrinhoCompra();
        this.cupomDesconto = compra.getCupomDesconto();
        this.resumoCompra=calculaValorFinal(Optional.ofNullable(compra.getCupomDesconto()), compra.getCarrinhoCompra());
    }

    public ResumoCompra calculaValorFinal(Optional<CupomDesconto> cupomDesconto, CarrinhoCompra carrinhoCompra){
        return new ResumoCompra().finalizandoCompra(cupomDesconto, carrinhoCompra);
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

    public ResumoCompra getResumoCompra() {
        return resumoCompra;
    }
}
