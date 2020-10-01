package br.com.ecommerce.cdc.exceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorMessage {

    private LocalDateTime timestamp;
    private String status;
    private String details;
    private List<String> errors;
    private String messageErroParaDesenvolvedor;

    public ErrorMessage(LocalDateTime timestamp, String status, String details, List<String> errors, String erroDesenvolvedor) {
        this.timestamp = timestamp;
        this.status = status;
        this.details = details;
        this.errors = errors;
        this.messageErroParaDesenvolvedor = erroDesenvolvedor;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public List<String> getErrors() {
        return errors;
    }

    public String getMessageErroParaDesenvolvedor() {
        return messageErroParaDesenvolvedor;
    }
}
