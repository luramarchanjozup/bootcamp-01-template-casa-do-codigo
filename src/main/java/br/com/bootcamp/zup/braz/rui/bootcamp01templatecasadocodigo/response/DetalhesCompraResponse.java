package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.response;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

        //this.totalPedido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }

    public String getCupomAplicado() {
        return cupomAplicado;
    }

    public void setCupomAplicado(String cupomAplicado) {
        this.cupomAplicado = cupomAplicado;
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

    public void setTotalComDesconto(BigDecimal totalComDesconto) {
        this.totalComDesconto = totalComDesconto;
    }

    public List<?> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<?> itensPedido) {
        this.itensPedido = itensPedido;
    }

    private BigDecimal valorTotalPedido(List<ItemCompraResponse> itensPedido){

        BigDecimal valorTotal = BigDecimal.ZERO;
        BigDecimal subTotal = BigDecimal.ZERO;

        for (ItemCompraResponse itemCompraResponse : itensPedido){
            valorTotal = itemCompraResponse.getValorUnitario().multiply(new BigDecimal(itemCompraResponse.getQuantidade()));
            subTotal = subTotal.add(valorTotal);
        }

        return subTotal;
    }

    private BigDecimal valorTotalComDesconto(List<ItemCompraResponse> itensPedido, Integer percentualDesconto){
        BigDecimal valorTotal = valorTotalPedido(itensPedido);
        BigDecimal valorDoDesconto = BigDecimal.ZERO;

        valorDoDesconto = valorTotal.multiply(new BigDecimal(25)).divide(new BigDecimal(100));

        return valorTotal.subtract(valorDoDesconto);

    }


}
