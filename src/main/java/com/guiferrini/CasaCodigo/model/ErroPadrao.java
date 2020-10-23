package com.guiferrini.CasaCodigo.model;

import java.util.Collection;

public class ErroPadrao {

	private Collection<String> mensagem;
	
	@Deprecated
	public ErroPadrao() {
	}

	public ErroPadrao(Collection<String> mensagem) {
		super();
		this.mensagem = mensagem;
	}

	public Collection<String> getMensagem() {
		return mensagem;
	}

	public void setMensagem(Collection<String> mensagem) {
		this.mensagem = mensagem;
	}	
}
