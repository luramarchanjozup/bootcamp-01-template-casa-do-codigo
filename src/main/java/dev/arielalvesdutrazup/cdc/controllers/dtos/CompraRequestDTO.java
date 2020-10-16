package dev.arielalvesdutrazup.cdc.controllers.dtos;

import dev.arielalvesdutrazup.cdc.annotations.CEP;
import dev.arielalvesdutrazup.cdc.annotations.Documento;
import dev.arielalvesdutrazup.cdc.entities.Compra;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class CompraRequestDTO {

    @NotBlank(message = "{nome.notempty}")
    private String nome;
    @NotBlank(message = "{sobrenome.notempty}")
    private String sobrenome;
    @NotBlank(message = "{email.notempty}")
    @Email(message = "{email.email}")
    private String email;
    @Documento
    @NotBlank(message = "{documento.notempty}")
    private String documento;
    @NotBlank(message = "{telefone.notempty}")
    private String telefone;
    @NotBlank(message = "{cidade.notempty}")
    private String cidade;
    @CEP
    @NotBlank(message = "{cep.notempty}")
    private String cep;
    @NotBlank(message = "{endereco.notempty}")
    private String endereco;
    private String complemento;
    @DecimalMin(value = "0", inclusive = false, message = "{total.min}")
    private BigDecimal total;
    private BigDecimal totalSemDesconto;
    @NotNull(message = "{paisId.notnull}")
    private Long paisId;
    private Long estadoId;
    private String cupomCodigo;
    @NotNull(message = "{itens.notnull}")
    @Size(min = 1, message = "{itens.size}")
    private Set<CompraItemRequestDTO> itens = new HashSet<>();

    public CompraRequestDTO() {
    }

    public String getNome() {
        return nome;
    }

    public CompraRequestDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public CompraRequestDTO setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CompraRequestDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDocumento() {
        return documento;
    }

    public CompraRequestDTO setDocumento(String documento) {
        this.documento = documento;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public CompraRequestDTO setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public CompraRequestDTO setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public CompraRequestDTO setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public CompraRequestDTO setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public CompraRequestDTO setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public CompraRequestDTO setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public BigDecimal getTotalSemDesconto() {
        return totalSemDesconto;
    }

    public CompraRequestDTO setTotalSemDesconto(BigDecimal totalSemDesconto) {
        this.totalSemDesconto = totalSemDesconto;
        return this;
    }

    public Long getPaisId() {
        return paisId;
    }

    public CompraRequestDTO setPaisId(Long paisId) {
        this.paisId = paisId;
        return this;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public CompraRequestDTO setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
        return this;
    }

    public String getCupomCodigo() {
        return cupomCodigo;
    }

    public CompraRequestDTO setCupomCodigo(String cupomCodigo) {
        this.cupomCodigo = cupomCodigo;
        return this;
    }

    public Set<CompraItemRequestDTO> getItens() {
        return itens;
    }

    public CompraRequestDTO setItens(Set<CompraItemRequestDTO> itens) {
        this.itens = itens;
        return this;
    }

    public Compra paraEntidade() {
        return new Compra()
                .setNome(nome)
                .setSobrenome(sobrenome)
                .setEmail(email)
                .setDocumento(documento)
                .setEndereco(endereco)
                .setCidade(cidade)
                .setCep(cep)
                .setComplemento(complemento)
                .setTelefone(telefone)
                .setTotal(total)
                .setTotalSemDesconto(total);
    }
}
