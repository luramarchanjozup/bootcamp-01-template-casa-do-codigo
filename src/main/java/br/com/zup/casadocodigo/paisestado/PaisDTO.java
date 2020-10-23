package br.com.zup.casadocodigo.paisestado;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.validacao.ValorUnico;

public class PaisDTO {

	// 1
	// 1
	@NotBlank
	@ValorUnico(classeDominio = Pais.class, nomeCampo = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais gerarNovoPais() {
		Pais novoPais = new Pais(this.nome);
		return novoPais;
	}

}
