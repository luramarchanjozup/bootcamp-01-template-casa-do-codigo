package br.com.itau.casadocodigo.cadastrocliente.model;

import br.com.itau.casadocodigo.cadastrocliente.repository.CupomRepository;
import br.com.itau.casadocodigo.cadastrocupom.model.Cupom;
import br.com.itau.casadocodigo.cadastropaisestado.model.Estado;
import br.com.itau.casadocodigo.validador.CPFouCNPJ;
import br.com.itau.casadocodigo.validador.VerificaEstadoPais;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Optional;

public class ClienteRequest {

    @NotBlank
    @Email
    private final String email;
    @NotBlank
    private final String nome;
    @NotBlank
    private final String sobrenome;
    @NotBlank
    @CPFouCNPJ //1
    private final String documento;
    @NotBlank
    private final String endereco;
    @NotBlank
    private final String complemento;
    @NotBlank
    private final String cidade;
    @NotBlank
    private final String pais;
    @NotBlank
    @VerificaEstadoPais(nomeDoAtributo = "estado", classeDeDominio = Estado.class) //1
    private final String estado;
    @NotBlank
    private final String telefone;
    @NotBlank
    private final String cep;
    private final CompraRequest compraRequest;
    private final String codigoDesconto;

    public ClienteRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                          @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                          @NotBlank String cidade, @NotBlank String pais, @NotBlank String estado,
                          @NotBlank String telefone, @NotBlank String cep, CompraRequest compraRequest, String codigoDesconto) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
        this.compraRequest = compraRequest;
        this.codigoDesconto = codigoDesconto;
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

    public String getDocumento() {
        return documento;
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

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public CompraRequest getCompraRequest() {
        return compraRequest;
    }

    public String getCodigoDesconto() {
        return codigoDesconto;
    }

//1 1 1 1 1
    public Cliente toClienteModel(CupomRepository cupomRepository) {
        Optional<Cupom> cupomCadastrado = cupomRepository.findByCodigo(this.codigoDesconto);

        CupomDesconto cupomDesconto = cupomCadastrado
                .map(cupom -> new CupomDesconto(cupom.getPercentual(), cupom.getValidade()))
                .orElse(null);

        return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento,
                this.cidade, this.pais, this.estado, this.telefone, this.cep, this.compraRequest.toCompraModel(cupomDesconto), cupomDesconto);
    }
//1
    public BigDecimal precoDoLivro(int posicaoDoLivro, EntityManager entityManager) {
        return this.compraRequest.getItens().get(posicaoDoLivro).calculaPreco(entityManager);
    }
}
