package com.cdcAPI.api.model.Request;

import com.cdcAPI.api.model.Response.EstadoResponse;
import com.cdcAPI.api.model.Response.PaisResponse;
import com.cdcAPI.model.Cliente;
import com.cdcAPI.model.Cupom;
import com.cdcAPI.model.Estado;
import com.cdcAPI.model.Pais;
import org.hibernate.criterion.CriteriaQuery;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

    private Long cupomId;

    public Cliente toModel(EntityManager manager) throws Exception {

        if (documento.length() != 11 && documento.length() != 14) {
            throw new Exception("Compra não pode ser efetuada. Documento inválido");
        }

        @NotBlank
        Pais pais = manager.find(Pais.class, paisId);
        Estado estado = manager.find(Estado.class, estadoId);
        List<Estado> estadosList = manager
                .createQuery("SELECT e from Estado e WHERE paisId = :paisId", Estado.class)
                .setParameter("paisId", paisId)
                .getResultList();

        if (pais == null) {
            throw new Exception("Compra não pode ser efetuada. Pais não existe.");
        } else if (estadosList.size() > 0) {
            if (estado == null) {
                throw new Exception("Campo 'estado' obrigatório.");
            } else if (!estado.getPaisId().equals(paisId)) {
                throw new Exception("Compra não pode ser efetuada. Este estado não pertence ao país selecionado.");
            }
        }

        Cupom cupom = manager.find(Cupom.class, cupomId);
        if (cupom == null) {
            throw new Exception("Compra não pode ser efetuada. Cupom não existe.");
        }
        if (!cupom.getValidade().isAfter(LocalDate.now())) {
            throw new Exception("Compra não pode ser efetuada. Cupom expirou.");
        }

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
