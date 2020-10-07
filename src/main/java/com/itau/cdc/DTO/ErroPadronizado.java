package com.itau.cdc.DTO;

import java.util.Collection;

public class ErroPadronizado {

	private Collection<String> mensagens;

	public ErroPadronizado(Collection<String> mensagens) {
		super();
		this.mensagens = mensagens;
	}

	public ErroPadronizado() {
		super();
	}

	public Collection<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(Collection<String> mensagens) {
		this.mensagens = mensagens;
	}
	
}
