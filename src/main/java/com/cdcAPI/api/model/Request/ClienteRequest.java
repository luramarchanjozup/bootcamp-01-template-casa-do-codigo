package com.cdcAPI.api.model.Request;

import com.cdcAPI.model.Cliente;
import com.cdcAPI.model.Cupom;
import com.cdcAPI.model.Estado;
import com.cdcAPI.model.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//Complexidade = 5
//Cliente, pais, estado, cupom, if

public class ClienteRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    private Long paisId;

    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    private Long cupomId = 0L;

    public Cliente toModel(EntityManager manager) throws Exception {

        Pais pais = manager.find(Pais.class, paisId);

        Estado estado = null;
        if (estadoId != null && estadoId > 0) {
            estado = manager.find(Estado.class, estadoId);
        }

        Cupom cupom = manager.find(Cupom.class, cupomId);

        return new Cliente(email, nome, sobrenome, documento, endereco, complemento,
                cidade, pais, estado, telefone, cep, cupom);
    }

    public Long getCupomId() {
        return cupomId;
    }

    public void setCupomId(Long cupomId) {
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
}
