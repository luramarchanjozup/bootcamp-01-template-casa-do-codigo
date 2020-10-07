package dev.arielalvesdutrazup.cdc.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String documento;
    private String telefone;
    private String cep;
    private String endereco;
    private String complemento;
    private BigDecimal total;
    private BigDecimal totalSemDesconto;
    private OffsetDateTime cadastradoEm;
    @ManyToOne
    private Pais pais;
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CompraItem> itens;

    public Long getId() {
        return id;
    }

    public Compra setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Compra setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Compra setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Compra setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDocumento() {
        return documento;
    }

    public Compra setDocumento(String documento) {
        this.documento = documento;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Compra setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public Compra setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public Compra setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public Compra setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public Pais getPais() {
        return pais;
    }

    public Compra setPais(Pais pais) {
        this.pais = pais;
        return this;
    }

    public Set<CompraItem> getItens() {
        return itens;
    }

    public Compra setItens(Set<CompraItem> itens) {
        this.itens = itens;
        return this;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Compra setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public BigDecimal getTotalSemDesconto() {
        return totalSemDesconto;
    }

    public Compra setTotalSemDesconto(BigDecimal totalSemDesconto) {
        this.totalSemDesconto = totalSemDesconto;
        return this;
    }

    public OffsetDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public Compra setCadastradoEm(OffsetDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
        return this;
    }
}
