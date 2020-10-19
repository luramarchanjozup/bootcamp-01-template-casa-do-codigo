package dev.arielalvesdutrazup.cdc.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

// 1 Uso de ?
@JsonInclude(NON_NULL)
public class ErroResponseDTO {

    private String erro;
    private Integer status;
    private String mensagem;
    private Instant instante;
    private String caminho;
    private List<?> erros;

    public ErroResponseDTO() {}

    public ErroResponseDTO(int status, Map<String, Object> errorAttributes) {
        this.status = status;
        this.erro = (String) errorAttributes.get("error");
        this.mensagem = (String) errorAttributes.get("message");
        this.caminho = (String) errorAttributes.get("path");
        this.erros = (List<?>) errorAttributes.get("errors");

        Date dateTimestamp = (Date) errorAttributes.get("timestamp");
        this.instante = dateTimestamp.toInstant();
    }

    public Instant getInstante() {
        return instante;
    }

    public ErroResponseDTO setInstante(Instant instante) {
        this.instante = instante;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ErroResponseDTO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMensagem() {
        return mensagem;
    }

    public ErroResponseDTO setMensagem(String mensagem) {
        this.mensagem = mensagem;
        return this;
    }

    public String getCaminho() {
        return caminho;
    }

    public ErroResponseDTO setCaminho(String caminho) {
        this.caminho = caminho;
        return this;
    }

    public String getErro() {
        return erro;
    }

    public ErroResponseDTO setErro(String erro) {
        this.erro = erro;
        return this;
    }

    public List<?> getErros() {
        return erros;
    }

    public ErroResponseDTO setErros(List<?> erros) {
        this.erros = erros;
        return this;
    }

    @Override
    public String toString() {
        return "ErroResponseDTO{" +
                "erro='" + erro + '\'' +
                ", status=" + status +
                ", mensagem='" + mensagem + '\'' +
                ", instante=" + instante +
                ", caminho='" + caminho + '\'' +
                ", erros=" + erros +
                '}';
    }
}
