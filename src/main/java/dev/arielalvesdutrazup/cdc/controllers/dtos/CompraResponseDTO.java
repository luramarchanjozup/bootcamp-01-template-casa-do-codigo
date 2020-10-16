package dev.arielalvesdutrazup.cdc.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.arielalvesdutrazup.cdc.entities.Compra;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class CompraResponseDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String documento;
    private String telefone;
    private String cidade;
    private String cep;
    private String endereco;
    private String complemento;
    private BigDecimal total;
    private BigDecimal totalSemDesconto;
    private PaisResponseDTO pais;
    private EstadoResponseDTO estado;
    private Set<CompraItemResponseDTO> itens = new HashSet<>();
    private CupomAplicadoDTO cupomAplicado;
    private OffsetDateTime cadastradoEm;

    public CompraResponseDTO() {
    }

    public CompraResponseDTO(Compra compra) {
        setId(compra.getId());
        setNome(compra.getNome());
        setSobrenome(compra.getSobrenome());
        setEmail(compra.getEmail());
        setDocumento(compra.getDocumento());
        setTelefone(compra.getTelefone());
        setComplemento(compra.getComplemento());
        setCidade(compra.getCidade());
        setCep(compra.getCep());
        setEndereco(compra.getEndereco());
        setTotal(compra.getTotal());
        setTotalSemDesconto(compra.getTotalSemDesconto());
        setItens(CompraItemResponseDTO.paraDTO(compra.getItens()));
        setPais(new PaisResponseDTO(compra.getPais()));
        setCadastradoEm(compra.getCadastradoEm());

        if (compra.getEstado() != null) {
            setEstado(new EstadoResponseDTO(compra.getEstado()));
        }

        if (compra.getCupomAplicado() != null) {
            setCupomAplicado(new CupomAplicadoDTO(compra.getCupomAplicado()));
        }
    }

    public Long getId() {
        return id;
    }

    public CompraResponseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public CompraResponseDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public CompraResponseDTO setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CompraResponseDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDocumento() {
        return documento;
    }

    public CompraResponseDTO setDocumento(String documento) {
        this.documento = documento;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public CompraResponseDTO setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public CompraResponseDTO setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public CompraResponseDTO setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public CompraResponseDTO setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public CompraResponseDTO setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public CompraResponseDTO setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public BigDecimal getTotalSemDesconto() {
        return totalSemDesconto;
    }

    public CompraResponseDTO setTotalSemDesconto(BigDecimal totalSemDesconto) {
        this.totalSemDesconto = totalSemDesconto;
        return this;
    }

    public PaisResponseDTO getPais() {
        return pais;
    }

    public CompraResponseDTO setPais(PaisResponseDTO pais) {
        this.pais = pais;
        return this;
    }

    public EstadoResponseDTO getEstado() {
        return estado;
    }

    public CompraResponseDTO setEstado(EstadoResponseDTO estado) {
        this.estado = estado;
        return this;
    }

    public Set<CompraItemResponseDTO> getItens() {
        return itens;
    }

    public CompraResponseDTO setItens(Set<CompraItemResponseDTO> itens) {
        this.itens = itens;
        return this;
    }

    public CupomAplicadoDTO getCupomAplicado() {
        return cupomAplicado;
    }

    public CompraResponseDTO setCupomAplicado(CupomAplicadoDTO cupomAplicado) {
        this.cupomAplicado = cupomAplicado;
        return this;
    }

    public OffsetDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public CompraResponseDTO setCadastradoEm(OffsetDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
        return this;
    }
}
