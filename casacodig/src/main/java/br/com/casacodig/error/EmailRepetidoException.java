package br.com.casacodig.error;

import org.springframework.http.HttpStatus;

public class EmailRepetidoException extends RuntimeException {
	
	private String mensagem;
	
	public EmailRepetidoException (String mensagem) {
        this.mensagem = mensagem;	 
	}
  
	@Override
	public String getMessage(){
	    return this.mensagem;
	}
}
