package br.com.ecommerce.cdc.domain.request;

import br.com.ecommerce.cdc.anotacao.CPFouCNPJ;
import br.com.ecommerce.cdc.anotacao.ExistInDataBase;
import br.com.ecommerce.cdc.domain.model.*;
import br.com.ecommerce.cdc.repository.CupomDescontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Optional;

/**
 * Carga Intrínseca máxima permitida - 9
 * Carga Intrínseca da classe - 5
 *
 */

public class CompraRequest {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @Size(min = 11, max = 14)
    @CPFouCNPJ
    private String cpfOuCnpj;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistInDataBase(nameClass = "Pais", nameFieldClass = Pais.class)
    private Long paisId;
    @NotNull
    @ExistInDataBase(nameClass = "Estado", nameFieldClass = Estado.class)
    private Long estadoId;
    @NotBlank @PositiveOrZero @Size(min = 8)
    private String telefone;
    @NotBlank
    @Size(min = 8)
    @PositiveOrZero
    private String cep;
    @Valid
    // +1
    private CarrinhoCompraRequest carrinhoCompra;

    @Valid
    private CupomDescontoAplicadoRequest aplicandoDesconto;

    public CompraRequest() {
    }

    public CompraRequest(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank @Size(min = 11, max = 14) String cpfOuCnpj, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Long paisId, @NotNull Long estadoId, @NotBlank @PositiveOrZero @Size(min = 8) String telefone, @NotBlank @Size(min = 8) String cep, CarrinhoCompraRequest carrinhoCompra, CupomDescontoAplicadoRequest aplicandoDesconto) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpfOuCnpj = cpfOuCnpj;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
        this.carrinhoCompra = carrinhoCompra;
        this.aplicandoDesconto = aplicandoDesconto;
    }
    // +1
    public Compra toModel(EntityManager manager, CupomDescontoRepository cupomDescontoRepository){
        // +1
        Pais pais = manager.find(Pais.class, paisId);
        // +1
        Estado estado = manager.find(Estado.class, estadoId);
        // +1
        CarrinhoCompra carrinhoCompra = this.carrinhoCompra.toModel(manager);
        Compra compra = new Compra(email, nome, sobrenome, cpfOuCnpj, endereco, complemento, cidade, pais, estado, telefone, cep, carrinhoCompra);
        Optional<CupomDescontoAplicadoRequest> aplicandoDesconto = Optional.ofNullable(this.aplicandoDesconto);
        if (aplicandoDesconto.isPresent() && aplicandoDesconto.get().getCodigo() != null){
            // +1
            Optional<CupomDesconto> cupomDescontoByCodigo = cupomDescontoRepository.findByCodigo(aplicandoDesconto.get().getCodigo());
            compra.aplicaCupomDesconto(cupomDescontoByCodigo.get());
        }

        return compra;
    }

    public double compraTotal(){
        return this.carrinhoCompra.getTotal().doubleValue();
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

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public CarrinhoCompraRequest getCarrinhoCompra() {
        return carrinhoCompra;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCarrinhoCompra(CarrinhoCompraRequest carrinhoCompra) {
        this.carrinhoCompra = carrinhoCompra;
    }

    public CupomDescontoAplicadoRequest getAplicandoDesconto() {
        return aplicandoDesconto;
    }

    public void setAplicandoDesconto(CupomDescontoAplicadoRequest aplicandoDesconto) {
        this.aplicandoDesconto = aplicandoDesconto;
    }

    @Override
    public String toString() {
        return "CompraRequest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cpfOuCnpj='" + cpfOuCnpj + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", paisId=" + paisId +
                ", estadoId=" + estadoId +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", carrinhoCompra=" + carrinhoCompra +
                '}';
    }
}
