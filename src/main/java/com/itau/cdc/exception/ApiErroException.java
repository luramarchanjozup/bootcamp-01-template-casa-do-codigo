package com.itau.cdc.exception;

import org.springframework.http.HttpStatus;

public class ApiErroException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final HttpStatus httpStatus;

    private final String reason;

    public ApiErroException(HttpStatus httpStatus, String reason) {
        super(reason);
        this.httpStatus = httpStatus;
        this.reason = reason;
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getReason() {
		return reason;
	}
	
}
