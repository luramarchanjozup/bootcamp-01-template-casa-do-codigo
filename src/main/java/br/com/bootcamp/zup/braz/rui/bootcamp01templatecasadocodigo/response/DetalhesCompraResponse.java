package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.response;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Compra;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class DetalhesCompraResponse {

    @NotBlank
    private String documento;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String telefone;
    @NotBlank
    private String email;
    @NotBlank
    private String cep;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotBlank
    private String pais;
    private String estado;
    @NotNull
    private BigDecimal totalPedido;
    private String cupomAplicado;
    private String percentualDesconto;
    private BigDecimal totalComDesconto;
    private List<?> itensPedido;

    public DetalhesCompraResponse(Compra compra, List<ItemCompraResponse> itensPedido){
        this.documento = compra.getDocumento();
        this.nome = compra.getNome();
        this.sobrenome = compra.getSobrenome();
        this.telefone = compra.getTelefone();
        this.email = compra.getEmail();
        this.cep = compra.getCep();
        this.endereco = compra.getEndereco();
        this.complemento = compra.getComplemento();
        this.cidade = compra.getCidade();
        this.estado = compra.getEstado().getNome();
        this.pais = compra.getPais().getNome();
        this.itensPedido = itensPedido;
        this.totalPedido = valorTotalPedido(itensPedido);
        this.cupomAplicado = compra.getCupomAplicado().getCupom().getCodigo();
        this.percentualDesconto = compra.getCupomAplicado().getCupom().getDesconto() + "%";
        this.totalComDesconto = valorTotalComDesconto(itensPedido, compra.getCupomAplicado().getCupom().getDesconto());

    }

    public String getDocumento() {
        return documento;
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

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCep() {
        return cep;
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

    public String getPais() {
        return pais;
    }


    public String getEstado() {
        return estado;
    }

     public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public String getCupomAplicado() {
        return cupomAplicado;
    }

    public String getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(String percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public BigDecimal getTotalComDesconto() {
        return totalComDesconto;
    }

    public List<?> getItensPedido() {
        return itensPedido;
    }
                                                //1
    private BigDecimal valorTotalPedido(List<ItemCompraResponse> itensPedido){

        BigDecimal valorTotal;
        BigDecimal subTotal = BigDecimal.ZERO;

        for (ItemCompraResponse itemCompraResponse : itensPedido){
            valorTotal = itemCompraResponse.getValorUnitario().multiply(new BigDecimal(itemCompraResponse.getQuantidade()));
            subTotal = subTotal.add(valorTotal);
        }

        return subTotal;
    }

    private BigDecimal valorTotalComDesconto(List<ItemCompraResponse> itensPedido, Integer percentualDesconto){
        BigDecimal valorTotal = valorTotalPedido(itensPedido);
        BigDecimal valorDoDesconto;

        valorDoDesconto = valorTotal.multiply(new BigDecimal(percentualDesconto)).divide(new BigDecimal(100));

        return valorTotal.subtract(valorDoDesconto);

    }


}
