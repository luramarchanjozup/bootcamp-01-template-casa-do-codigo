package br.com.casacodig.error;

import java.util.Collection;

//Contagem de Pontos - TOTAL:0


public class ErroPadronizado {
	
	private Collection<String> mensagens;
	
	
	public ErroPadronizado(Collection<String> mensagens) {
		this.mensagens = mensagens;
	}
	
	public Collection<String> getMensagens() {
		return this.mensagens;
	}
	
}
