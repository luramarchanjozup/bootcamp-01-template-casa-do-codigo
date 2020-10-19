package dev.arielalvesdutrazup.cdc.entities;

import dev.arielalvesdutrazup.cdc.annotations.CEP;
import dev.arielalvesdutrazup.cdc.annotations.Documento;
import dev.arielalvesdutrazup.cdc.entities.embedded.CupomAplicado;
import dev.arielalvesdutrazup.cdc.utils.BigDecimalUtils;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import static dev.arielalvesdutrazup.cdc.utils.BigDecimalUtils.discontaPorcentagemDe;

// Annotations
// 1 @CEP
// 2 @Documento

// Other entities
// 3 CupomAplicado.java
// 4 Pais.java >>
// 5 Estado.java >>
// 6 CompraItem.java

// Utils
// 7 BigDecimalUtils.java >>

// Ifs
// 8 if (itens != null)

// Loops/Iterations
// 9 itens.forEach(item -> { item.setCompra(this); })

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private OffsetDateTime cadastradoEm = OffsetDateTime.now();
    @ManyToOne
    @NotNull(message = "{pais.notnull}")
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @NotNull(message = "{itens.notnull}")
    @Size(min = 1, message = "{itens.size}")
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CompraItem> itens = new HashSet<>();
    @Embedded
    private CupomAplicado cupomAplicado;

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

    public String getCidade() {
        return cidade;
    }

    public Compra setCidade(String cidade) {
        this.cidade = cidade;
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

    public Estado getEstado() {
        return estado;
    }

    public Compra setEstado(Estado estado) {
        this.estado = estado;
        return this;
    }

    public Set<CompraItem> getItens() {
        return itens;
    }

    public Compra setItens(Set<CompraItem> itens) {
        this.itens = itens;
        if (itens != null) {
            itens.forEach(item -> { item.setCompra(this); });
        }
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

    public CupomAplicado getCupomAplicado() {
        return cupomAplicado;
    }

    public Compra setCupomAplicado(CupomAplicado cupomAplicado) {
        this.cupomAplicado = cupomAplicado;
        return this;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", documento='" + documento + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cidade='" + cidade + '\'' +
                ", cep='" + cep + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", total=" + total +
                ", totalSemDesconto=" + totalSemDesconto +
                ", cadastradoEm=" + cadastradoEm +
                ", cupomAplicado=" + cupomAplicado +
                '}';
    }

    public BigDecimal getTotalDosItens() {
        return CompraItem.calculaTotalDosItens(itens, cupomAplicado);
    }

    public void validaTotalComTotalDosItens() {
        Assert.isTrue(ehTotalMaiorQueZero(), "Total deve ser maior que zero!");
        Assert.isTrue(temItensValidos(), "É obrigatório ao menos 1 item de compra!");
        Assert.isTrue(ehTotalIgualTotalDosItens(), "O total difere do valor dos itens da compra!");
    }

    private boolean temItensValidos() {
        return itens != null && !itens.isEmpty();
    }

    private boolean ehTotalMaiorQueZero() {
        return total != null && BigDecimalUtils.maiorQue(total, BigDecimal.ZERO);
    }

    public boolean ehTotalIgualTotalDosItens() {
        return total.equals(getTotalDosItens());
    }

    @PrePersist
    @PreUpdate
    private void beforeSave() {
        validaTotalComTotalDosItens();
    }

    public CupomAplicado aplicaCupom(Cupom cupom) {
        Assert.notNull(cupom, "Cupom inválido para a aplicação de desconto!");

        total = discontaPorcentagemDe(cupom.getPercentualDeDesconto(), total);
        cupomAplicado = new CupomAplicado(cupom);

        return cupomAplicado;
    }
}
