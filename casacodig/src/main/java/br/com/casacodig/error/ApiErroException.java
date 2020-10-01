package br.com.casacodig.error;

import org.springframework.http.HttpStatus;

//Contagem de Pontos - TOTAL:0

public class ApiErroException extends RuntimeException {

	private final HttpStatus httpStatus;

    private final String reason;

    public ApiErroException(HttpStatus httpStatus, String reason) {
        super(reason);
        this.httpStatus = httpStatus;
        this.reason = reason;
    }
    
	public String getReason() {
		return this.reason;
	}
	
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}
}
