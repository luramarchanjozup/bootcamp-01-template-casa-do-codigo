package br.com.ecommerce.cdc.domain.request;

import br.com.ecommerce.cdc.anotacao.ExistInDataBase;
import br.com.ecommerce.cdc.anotacao.NotDuplicated;
import br.com.ecommerce.cdc.domain.model.Estado;
import br.com.ecommerce.cdc.domain.model.Pais;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;

public class CadastroRequest {

    @Email
    @NotBlank
    @NotDuplicated(fieldName = "email", nameClass = "Cadastro")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @Size(min = 11, max = 14)
    @NotDuplicated(nameClass = "Cadastro", fieldName = "cpfOuCnpj")
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
    private String cep;

    public CadastroRequest() {
    }

    public CadastroRequest(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank @Size(min = 11, max = 14) String cpfOuCnpj, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Long paisId, @NotNull Long estadoId, @NotBlank @PositiveOrZero @Size(min = 8) String telefone, @NotBlank @Size(min = 8) String cep) {
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
    }

    /*    public Cadastro toModel(){
        return new Cadastro(email,nome,sobrenome,cpfOuCnpj,endereco,complemento,cidade,paisId, estadoId,telefone,cep);
    }*/

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

    @Override
    public String toString() {
        return "CadastroRequest{" +
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
                '}';
    }
}
