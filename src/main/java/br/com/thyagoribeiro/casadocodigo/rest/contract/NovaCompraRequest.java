package br.com.thyagoribeiro.casadocodigo.rest.contract;

import br.com.thyagoribeiro.casadocodigo.domain.Compra;
import br.com.thyagoribeiro.casadocodigo.domain.Estado;
import br.com.thyagoribeiro.casadocodigo.domain.Pais;
import br.com.thyagoribeiro.casadocodigo.domain.Pedido;
import br.com.thyagoribeiro.casadocodigo.validator.CupomValido;
import br.com.thyagoribeiro.casadocodigo.validator.Document;
import br.com.thyagoribeiro.casadocodigo.validator.DocumentType;
import br.com.thyagoribeiro.casadocodigo.validator.Exist;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// CDD - Total: 5

public class NovaCompraRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @Document(documentTypes = {DocumentType.CPF, DocumentType.CNPJ}) // CDD 1 - Interface @Document
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @Exist(domainClass = Pais.class, fieldName = "id", expected = true) // CDD 1 - Classe Pais
    private Long paisId;

    @NotNull
    @Exist(domainClass = Estado.class, fieldName = "id", expected = true) // CDD 1 - classe Estado
    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @NotNull
    @Valid
    private NovoPedidoRequest pedido; // CDD 1 - Classe NovoPedidoRequest

    @CupomValido
    private Long cupomId;

    @Deprecated
    public NovaCompraRequest() {
    }

    public NovaCompraRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String endereco, @NotBlank String complemento,
                             @NotBlank String cidade, @NotNull Long paisId, @NotNull Long estadoId, @NotBlank String telefone, @NotBlank String cep, @NotNull @Valid NovoPedidoRequest pedido, @Valid Long cupomId) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
        this.cupomId = cupomId;
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

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
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

    public NovoPedidoRequest getPedido() {
        return pedido;
    }

    public void setPedido(NovoPedidoRequest pedido) {
        this.pedido = pedido;
    }

    public Long getCupomId() {
        return cupomId;
    }

    public void setCupomId(Long cupomId) {
        this.cupomId = cupomId;
    }

    public Compra toModel(){ // CDD 1 - classe Compra
        Pedido pedido = this.pedido.toModel();
        return new Compra(email, nome, sobrenome, documento, endereco, complemento, cidade, paisId, estadoId, telefone, cep, pedido, cupomId);
    }

}
